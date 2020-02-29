package Singleton;

/**
 * @description: StaticInnerClassSingleton:使用内部类创建单例
 * @date: 2020/2/29 22:06
 * @author: Finallap
 * @version: 1.0
 */
public class StaticInnerClassSingleton {
    private StaticInnerClassSingleton() {
    }

    private static class StaticInnerClassSingletonHolder {
        private static final StaticInnerClassSingleton instance = new StaticInnerClassSingleton();
    }

    public static StaticInnerClassSingleton getInstance() {
        return StaticInnerClassSingletonHolder.instance;
    }

}
