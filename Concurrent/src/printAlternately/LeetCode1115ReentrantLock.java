package printAlternately;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: LeetCode problem1115:多线程交替打印FooBar，使用ReentrantLock来搞定
 * @date: 2020/4/1 15:27
 * @author: Finallap
 * @version: 1.0
 */
public class LeetCode1115ReentrantLock {
    private int n;
    private ReentrantLock lock = new ReentrantLock(true);
    volatile boolean permitFoo = true;

    public LeetCode1115ReentrantLock(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; ) {
            lock.lock();
            try {
                if (permitFoo) {
                    printFoo.run();
                    i++;
                    permitFoo = false;
                }
            } finally {
                lock.unlock();
            }

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; ) {
            lock.lock();
            try {
                if (!permitFoo) {
                    printBar.run();
                    i++;
                    permitFoo = true;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
