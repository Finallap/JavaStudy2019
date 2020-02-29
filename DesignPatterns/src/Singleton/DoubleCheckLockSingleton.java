package Singleton;

/**
 * @description: DoubleCheckLockSingleton:双重校验锁单例模式，避免了创建多个实例
 * @date: 2020/2/29 21:54
 * @author: Finallap
 * @version: 1.0
 */
public class DoubleCheckLockSingleton {
    //使用volatile关键字修饰，保证变量的可见性，也防止指令重排
    private static volatile DoubleCheckLockSingleton instance = null;

    private DoubleCheckLockSingleton() {
    }

    public static DoubleCheckLockSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckLockSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckLockSingleton();
                }
            }
        }
        return instance;
    }
}
