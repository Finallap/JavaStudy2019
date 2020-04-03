import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: ProviderConsumer
 * @date: 2020/4/3 17:52
 * @author: Finallap
 * @version: 1.0
 */
public class ProviderConsumer {
    public static void main(String[] args) {
        Resource resource = new Resource();
        new Thread(new Provider(resource)).start();
        new Thread(new Consumer(resource)).start();
        new Thread(new Consumer(resource)).start();
    }

    static class Provider implements Runnable {
        Resource resource = null;

        public Provider(Resource resource) {
            this.resource = resource;
        }

        @Override
        public void run() {
            try {
                product(resource);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void product(Resource resource) throws Exception {
            int count = 0;
            while (count < 100) {
                resource.productResource("time:" + System.currentTimeMillis());
                count++;
                Thread.sleep(4);
            }
        }
    }

    static class Consumer implements Runnable {
        Resource resource = null;

        public Consumer(Resource resource) {
            this.resource = resource;
        }

        @Override
        public void run() {
            try {
                consume(resource);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void consume(Resource resource) throws Exception {
            int count = 0;
            while (count < 100) {
                resource.consumeResource();
                count++;
                Thread.sleep(10);
            }
        }
    }

    static class Resource {
        private Queue<String> queue = null;

        public Resource() {
            this.queue = new LinkedList<>();
        }

        public synchronized void productResource(String s) throws Exception {
            if (queue.size() < 10) {
                queue.offer(s);
                this.notifyAll();
            } else {
                this.wait();
            }
        }

        public synchronized void consumeResource() throws Exception {
            if (queue.size() > 0) {
                System.out.println("Queue size:" + queue.size());
                System.out.println(queue.poll());
                this.notifyAll();
            } else {
                this.wait();
            }
        }
    }
}
