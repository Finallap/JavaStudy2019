package printAlternately;

/**
 * @description: DeadLock: 一个新鲜的死锁程序
 * @date: 2020/4/1 17:41
 * @author: Finallap
 * @version: 1.0
 */
public class DeadLock {
    private static Object a = new Object();
    private static Object b = new Object();

    public static void main(String[] args) {
        new Thread(new Runnable1()).start();
        new Thread(new Runnable2()).start();
    }

    public static class Runnable1 implements Runnable {
        @Override
        public void run() {
            synchronized (a) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {

                }
                synchronized (b) {

                }
            }
        }
    }

    public static class Runnable2 implements Runnable {
        @Override
        public void run() {
            synchronized (b) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {

                }
                synchronized (a) {

                }
            }
        }
    }
}
