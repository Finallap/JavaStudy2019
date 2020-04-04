package printAlternately;

import java.util.concurrent.Semaphore;

/**
 * @description: semaphore
 * @date: 2020/4/2 17:52
 * @author: Finallap
 * @version: 1.0
 */
public class ABC_Semaphore {
    private static Semaphore semaphoreA = new Semaphore(1);
    private static Semaphore semaphoreB = new Semaphore(0);
    private static Semaphore semaphoreC = new Semaphore(0);

    public static class runnableA implements Runnable {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    semaphoreA.acquire();
                    System.out.println(Thread.currentThread().getName());
                    semaphoreB.release();
                }
            } catch (Exception e) {

            }
        }
    }

    public static class runnableB implements Runnable {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    semaphoreB.acquire();
                    System.out.println(Thread.currentThread().getName());
                    semaphoreC.release();
                }
            } catch (Exception e) {

            }
        }
    }

    public static class runnableC implements Runnable {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    semaphoreC.acquire();
                    System.out.println(Thread.currentThread().getName());
                    semaphoreA.release();
                }
            } catch (Exception e) {

            }
        }
    }

    public static void main(String[] args) throws Exception {
        Thread threadA = new Thread(new runnableA());
        Thread threadB = new Thread(new runnableB());
        Thread threadC = new Thread(new runnableC());
        threadA.setName("A");
        threadB.setName("B");
        threadC.setName("C");
        threadA.start();
        Thread.sleep(10);
        threadB.start();
        Thread.sleep(10);
        threadC.start();
    }
}
