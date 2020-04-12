package Alibaba_Taobao_20200401;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: printAlternately
 * // 多线程交叉打印
 * // 建立三个线程,线程名字分别为:A、B、C，要求三个线程分别打印自己的线程名字,但是要求三个线程同时运行，
 * // 并且实现交替打印，即按照ABCABCABC的顺序打印。打印10轮，打印完毕控制台输出字符串:"打印完毕"
 * @date: 2020/4/1 14:51
 * @author: Finallap
 * @version: 1.0
 */
public class printAlternately {
    public static void main(String[] args) {
        PrintThreadA threadA = new PrintThreadA();
        PrintThreadB threadB = new PrintThreadB();
        PrintThreadB threadC = new PrintThreadB();

        threadA.start();
        threadB.start();
        threadC.start();

        lock.lock();
        try {
            conditionA.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition conditionA = lock.newCondition();
    private static final Condition conditionB = lock.newCondition();
    private static final Condition conditionC = lock.newCondition();
    private static volatile int printCount = 0;


    public static class PrintThreadA extends Thread {
        @Override
        public void run() {
            lock.lock();
            try {
                int count = 10;
                while (count > 0) {
                    while (printCount % 3 != 0) {
                        conditionA.await();
                    }
                    System.out.println(Thread.currentThread().getName());
                    printCount++;
                    count--;
                    conditionB.signal();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static class PrintThreadB extends Thread {
        @Override
        public void run() {
            lock.lock();
            try {
                int count = 10;
                while (count > 0) {
                    while (printCount % 3 != 1) {
                        conditionB.await();
                    }
                    System.out.println(Thread.currentThread().getName());
                    printCount++;
                    count--;
                    conditionC.signal();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static class PrintThreadC extends Thread {
        @Override
        public void run() {
            lock.lock();
            try {
                int count = 10;
                while (count > 0) {
                    while (printCount % 3 != 2) {
                        conditionC.await();
                    }
                    System.out.println(Thread.currentThread().getName());
                    printCount++;
                    count--;
                    conditionA.signal();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
