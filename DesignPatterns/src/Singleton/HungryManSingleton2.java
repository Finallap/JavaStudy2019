package Singleton;

/**
 * @description: HungryManSingleton2:饿汉式单例模式（一种变种），初始化时即创建，不存在线程问题
 * @date: 2020/2/29 21:43
 * @author: Finallap
 * @version: 1.0
 */
public class HungryManSingleton2 {
    private static HungryManSingleton2 instance = null;

    static {
        instance = new HungryManSingleton2();
    }

    private HungryManSingleton2() {
    }

    public static HungryManSingleton2 getInstance() {
        return instance;
    }
}
