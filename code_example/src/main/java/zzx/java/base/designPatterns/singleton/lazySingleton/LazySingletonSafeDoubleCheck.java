package zzx.java.base.designPatterns.singleton.lazySingleton;

/**
 * 懒汉模式
 * 双重检测
 * 线程安全
 */
public class LazySingletonSafeDoubleCheck {

    //使用volatile关键字防止重排序，因为 new Instance()是一个非原子操作，可能创建一个不完整的实例
    private static volatile LazySingletonSafeDoubleCheck singleton;

    private LazySingletonSafeDoubleCheck() {}

    public static LazySingletonSafeDoubleCheck getInstance() {
        // 双重检测
        if (singleton == null) {
            synchronized (LazySingletonSafeDoubleCheck.class) {
                // 只需在第一次创建实例时才同步
                if (singleton == null) {
                    singleton = new LazySingletonSafeDoubleCheck();
                }
            }
        }
        return singleton;
    }
}
