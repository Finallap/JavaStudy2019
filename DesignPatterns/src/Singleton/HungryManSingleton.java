package Singleton;

/**
 * @description: HungryManSingleton:饿汉式单例模式，初始化时即创建，不存在线程问题
 * @date: 2020/2/29 21:40
 * @author: Finallap
 * @version: 1.0
 */
public class HungryManSingleton {
    private static HungryManSingleton instance = new HungryManSingleton();

    private HungryManSingleton() {
    }

    public static HungryManSingleton getInstance() {
        return instance;
    }
}
