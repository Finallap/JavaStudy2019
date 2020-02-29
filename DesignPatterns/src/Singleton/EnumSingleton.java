package Singleton;

/**
 * @description: EnumSingleton:枚举式单例
 * @date: 2020/2/29 22:16
 * @author: Finallap
 * @version: 1.0
 */
public enum EnumSingleton {
    SINGLETON;

    public void tellEveryone() {
        System.out.println("This is an EnumSingleton " + this.hashCode());
    }
}
