package Alibaba_Taobao_20200411.Problem3;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * @description: Server
 * 创建一个Socket Server，能够同时接受至少1024个TCP客户端的连接请求
 * 当客户端连接到Server以后，任意一个客户端可以向server发送一串字符
 * 如果客户端（如第二个连接）发送的字符串为”2,34,14,6,8”这样用半角逗号分隔的整型数组，则服务器对数组进行倒排，然后发送给除了当前客户端之外的其他客户端，如果不是这样的字符串，则不做处理
 * 因为多个客户端同时连接到服务器，所以存在超过一个客户端同时发送字符串给服务端的情况，要求所有请求都能在毫秒级被处理完，不能阻塞
 * @date: 2020/4/11 23:34
 * @author: Finallap
 * @version: 1.0
 */
public class Server implements Runnable {
    private final int port;
    private Selector selector;
    private ServerSocketChannel serverSocketChannel;

    public Server(int port) {
        this.port = port;
    }

    public void init() {
        try {
            selector = Selector.open();
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.socket().bind(new InetSocketAddress(port));
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        init();
        while (true) {
            try {
                selector.select();
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();
                    handleKey(selectionKey);
                    iterator.remove();
                }
                selector.selectedKeys().clear();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleKey(SelectionKey key) throws IOException {
        if (key.isAcceptable()) {
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
            SocketChannel socketChannel = serverSocketChannel.accept();
            socketChannel.configureBlocking(false);
            socketChannel.register(selector, SelectionKey.OP_READ);
        }
        if (key.isReadable()) {
            SocketChannel socketChannel = (SocketChannel) key.channel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int byteCount = socketChannel.read(buffer);
            if (byteCount < 0) {
                key.cancel();
                socketChannel.close();
                return;
            }

            if (byteCount > 0) {
                buffer.flip();
                byte[] bytes = new byte[buffer.remaining()];
                buffer.get(bytes);
                String message = new String(bytes, StandardCharsets.UTF_8);
                if (isValue(message)) {
                    boardMessage(strProcess(message), socketChannel, buffer);
                }
            }
        }
    }

    private void boardMessage(String msg, SocketChannel except, ByteBuffer buffer) {
        try {
            for (SelectionKey k : selector.keys()) {
                Channel target = k.channel();
                if (target instanceof SocketChannel && target.isOpen() && target != except) {
                    write((SocketChannel) target, msg, buffer);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void write(SocketChannel channel, String content, ByteBuffer buffer) throws IOException {
        buffer.clear();
        buffer.put(content.getBytes(StandardCharsets.UTF_8));
        buffer.flip();
        channel.write(buffer);
    }


    public boolean isValue(String str) {
        if (str.contains(",")) {
            String[] strs = str.split(",");
            for (String s : strs) {
                if (!isNumeric(s)) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean isNumeric(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == 0 && (c == '+' || c == '-')) {
                continue;
            }
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    public static String strProcess(String str) {
        String[] strs = str.split(",");
        Collections.reverse(Arrays.asList(strs));
        return String.join(",", strs);
    }

    public static void main(String[] args) {
        Server server = new Server(8000);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(server);
    }
}