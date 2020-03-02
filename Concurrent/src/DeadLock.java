import java.util.Arrays;
import java.util.List;

/**
 * @description: DeadLock
 * @date: 2020/3/1 17:54
 * @author: Finallap
 * @version: 1.0
 */
public class DeadLock {
    public static void main(String[] args) {
        final List<Integer> list1 = Arrays.asList(1, 2, 3);
        final List<Integer> list2 = Arrays.asList(4, 5, 6);

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (list1) {
                    for (int num : list1) {
                        System.out.println(num);
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (list2) {
                        for (int num : list2) {
                            System.out.println(num);
                        }
                    }
                }
            }
        }
        ).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (list2) {
                    for (int num : list2) {
                        System.out.println(num);
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (list1) {
                        for (int num : list1) {
                            System.out.println(num);
                        }
                    }
                }
            }
        }
        ).start();
    }
}
