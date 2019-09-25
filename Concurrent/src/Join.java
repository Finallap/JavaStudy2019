import java.util.concurrent.TimeUnit;

public class Join {
    public static void main(String[] args) throws Exception {
        Thread previous = Thread.currentThread();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Domino(previous), String.valueOf(i));
            thread.start();
            previous = thread;
        }
        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName() + " terminate.");
    }

    static class Domino implements Runnable {
        Thread previous;

        public Domino(Thread previous) {
            this.previous = previous;
        }

        @Override
        public void run() {
            try {
                previous.join();
            } catch (InterruptedException e) {

            }
            System.out.println(Thread.currentThread().getName() + " terminate.");
        }
    }
}
