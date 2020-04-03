package printAlternately;

import java.util.concurrent.CyclicBarrier;

/**
 * @description: ABC_synch
 * @date: 2020/4/1 15:55
 * @author: Finallap
 * @version: 1.0
 */
public class ABC_synch {
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

    public static class ThreadPrint implements Runnable {
        private Object pre;
        private Object self;

        public ThreadPrint(Object pre, Object self) {
            this.pre = pre;
            this.self = self;
        }

        @Override
        public void run() {
            int count = 10;
            while (count > 0) {
                //进入前确保先获取pre锁
                synchronized (pre) {
                    //再获取self锁
                    synchronized (self) {
                        System.out.println(Thread.currentThread().getName());
                        count--;
                        self.notifyAll();//唤醒其他线程，竞争self锁
                    }
                    //此时释放self的锁
                    try {
                        if (count == 0) {
                            //如果10次都打印完了，那使用notifyAll来释放掉pre锁，否则线程不会结束
                            pre.notifyAll();
                        } else {
                            // 立即释放 prev锁，当前线程休眠，等待唤醒
                            pre.wait();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();

        ThreadPrint threadPrintA = new ThreadPrint(c, a);
        ThreadPrint threadPrintB = new ThreadPrint(a, b);
        ThreadPrint threadPrintC = new ThreadPrint(b, c);
        new Thread(threadPrintA, "A").start();
        Thread.sleep(10);
        new Thread(threadPrintB, "B").start();
        Thread.sleep(10);
        new Thread(threadPrintC, "C").start();
        Thread.sleep(10);
    }
}
