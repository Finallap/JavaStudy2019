import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @description: FutureTaskExample:放入Callable，形成异步任务
 * @date: 2020/3/7 19:43
 * @author: Finallap
 * @version: 1.0
 */
public class FutureTaskExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();

        Callable callable1 = new Callable() {
            @Override
            public Object call() throws Exception {
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return "包子准备完毕";
            }
        };

        FutureTask<String> task1 = new FutureTask<>(callable1);
        new Thread(task1).start();

        Callable callable2 = new Callable() {
            @Override
            public Object call() throws Exception {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return "凉菜准备完毕";
            }
        };

        FutureTask<String> task2 = new FutureTask<>(callable2);
        new Thread(task2).start();

        System.out.println(task1.get());
        System.out.println(task2.get());


        long end = System.currentTimeMillis();
        System.out.println("准备完毕时间：" + (end - start));
    }
}
