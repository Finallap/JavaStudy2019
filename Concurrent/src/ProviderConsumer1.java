import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description: ProviderConsumer1
 * @date: 2020/4/3 18:27
 * @author: Finallap
 * @version: 1.0
 */
public class ProviderConsumer1 {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>(10);

        Provider p1 = new Provider(queue);
        Provider p2 = new Provider(queue);
        Provider p3 = new Provider(queue);

        Consumer c1 = new Consumer(queue);
        Consumer c2 = new Consumer(queue);
        Consumer c3 = new Consumer(queue);

        ExecutorService es = Executors.newCachedThreadPool();
        es.execute(p1);
        es.execute(p2);
        es.execute(p3);

        es.execute(c1);
        es.execute(c2);
        es.execute(c3);

        try {
            Thread.sleep(4000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        p1.stop();
        p2.stop();
        p3.stop();

        c1.stop();
        c2.stop();
        c3.stop();

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class Provider implements Runnable {
        private BlockingQueue<String> queue;
        private Random r = new Random();
        private volatile boolean isRunning = true;
        private static AtomicInteger count = new AtomicInteger(0);

        public Provider(BlockingQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (isRunning) {
                try {
                    Thread.sleep(r.nextInt(1000));
                    int id = count.incrementAndGet();
                    System.out.println(Thread.currentThread().getName() + "生产数据：" + id + ",加载到缓冲区");
                    if (!queue.offer(Integer.toString(id), 2, TimeUnit.SECONDS)) {
                        System.out.println("提交缓冲区数据失败。。。。");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public void stop() {
            isRunning = false;
        }
    }

    public static class Consumer implements Runnable {
        private BlockingQueue<String> queue = null;
        private Random r = new Random();
        private volatile boolean isRunning = true;

        public Consumer(BlockingQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (isRunning) {
                try {
                    String data = queue.take();
                    Thread.sleep(r.nextInt(1000));
                    System.out.println(Thread.currentThread().getName() + "消费：" + data);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public void stop() {
            isRunning = false;
        }
    }
}
