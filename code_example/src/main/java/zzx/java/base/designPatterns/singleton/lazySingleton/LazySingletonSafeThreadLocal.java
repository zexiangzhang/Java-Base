package zzx.java.base.designPatterns.singleton.lazySingleton;

/**
 * 懒汉模式
 * 线程安全
 * ThreadLocal
 */
public class LazySingletonSafeThreadLocal {

    // ThreadLocal 线程局部变量，将单例instance线程私有化
    private static ThreadLocal<LazySingletonSafeThreadLocal> threadLocal = new ThreadLocal<>();
    private static LazySingletonSafeThreadLocal instance;

    private LazySingletonSafeThreadLocal() {}

    public static LazySingletonSafeThreadLocal getInstance() {
        // 第一次检查：若线程第一次访问，则进入if语句块；否则，若线程已经访问过，则直接返回ThreadLocal中的值
        if (threadLocal.get() == null) {
            synchronized (LazySingletonSafeThreadLocal.class) {
                // 第二次检查：该单例是否被创建
                if (instance == null) {
                    instance = new LazySingletonSafeThreadLocal();
                }
            }
            // 将单例放入ThreadLocal中
            threadLocal.set(instance);
        }
        return threadLocal.get();
    }
}
