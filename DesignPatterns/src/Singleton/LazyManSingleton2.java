package Singleton;

/**
 * @description: LazyManSingleton2:懒汉式单例模式，需要时候再创建，用synchronized修饰后线程问题解决
 * @date: 2020/2/29 21:48
 * @author: Finallap
 * @version: 1.0
 */
public class LazyManSingleton2 {
    private static LazyManSingleton2 instance = null;

    private LazyManSingleton2() {
    }

    public static synchronized LazyManSingleton2 getInstance() {
        if (instance == null) {
            instance = new LazyManSingleton2();
        }
        return instance;
    }
}
