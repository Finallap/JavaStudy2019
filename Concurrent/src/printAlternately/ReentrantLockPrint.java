package printAlternately;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: ReentrantLockPrint
 * @date: 2020/4/4 10:23
 * @author: Finallap
 * @version: 1.0
 */
public class ReentrantLockPrint {
    private static ReentrantLock lock = new ReentrantLock();

    public static class Print implements Runnable {
        @Override
        public void run() {
            lock.lock();
            try {
                for (int i = 0; i < 3; i++) {
                    System.out.println(Thread.currentThread().getName() + "输出了：  " + i);
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new Print(), "A").start();
        new Thread(new Print(), "B").start();
    }
}
