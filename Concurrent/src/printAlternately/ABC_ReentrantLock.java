package printAlternately;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: ABC_ReentrantLock
 * @date: 2020/4/1 18:55
 * @author: Finallap
 * @version: 1.0
 */
public class ABC_ReentrantLock {
    private static ReentrantLock lock = new ReentrantLock(true);

    public static class PrintThread implements Runnable {
        private Condition self = null;
        private Condition next = null;

        int count = 0;

        public PrintThread(Condition self, Condition next, int count) {
            this.self = self;
            this.next = next;
            this.count = count;
        }

        @Override
        public void run() {
            lock.lock();
            try {
                while (count > 0) {
                    self.await();
                    System.out.println(Thread.currentThread().getName());
                    count--;
                    next.signal();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
    }


    public static void main(String[] args) throws InterruptedException {
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();

        PrintThread printThreadA = new PrintThread(conditionA, conditionB, 10);
        PrintThread printThreadB = new PrintThread(conditionB, conditionC, 10);
        PrintThread printThreadC = new PrintThread(conditionC, conditionA, 10);

        Thread threadA = new Thread(printThreadA, "A");
        Thread threadB = new Thread(printThreadB, "B");
        Thread threadC = new Thread(printThreadC, "C");

        threadA.start();
        Thread.sleep(10);
        threadB.start();
        Thread.sleep(10);
        threadC.start();

        lock.lock();
        try {
            conditionA.signal();
        } finally {
            lock.unlock();
        }
    }
}
