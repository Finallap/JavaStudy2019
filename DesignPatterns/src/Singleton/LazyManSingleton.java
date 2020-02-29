package Singleton;

/**
 * @description: LazyManSingleton:懒汉式单例模式，需要时候再创建，存在线程问题
 * @date: 2020/2/29 21:45
 * @author: Finallap
 * @version: 1.0
 */
public class LazyManSingleton {
    private static LazyManSingleton instance = null;

    private LazyManSingleton() {
    }

    public static LazyManSingleton getInstance() {
        if (instance == null) {
            instance = new LazyManSingleton();
        }
        return instance;
    }
}
