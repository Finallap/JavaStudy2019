import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: ConcurrentSum: 使用ReentrantLock避免多线程求和出问题
 * @date: 2020/4/4 11:40
 * @author: Finallap
 * @version: 1.0
 */
public class ConcurrentSum {
    private static ReentrantLock lock = new ReentrantLock();
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 500; i++) {
            es.execute(() -> add());
        }
        Thread.sleep(2000);
        System.out.println(count);
    }

    private static void add() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }
}
