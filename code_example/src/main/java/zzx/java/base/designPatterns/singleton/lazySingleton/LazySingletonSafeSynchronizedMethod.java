package zzx.java.base.designPatterns.singleton.lazySingleton;

/**
 * 懒汉模式
 * 同步延迟加载
 * 线程安全
 * synchronized方法
 */
public class LazySingletonSafeSynchronizedMethod {

    private static LazySingletonSafeSynchronizedMethod singleton;

    private LazySingletonSafeSynchronizedMethod(){}

    // 使用 synchronized 修饰，临界资源的同步互斥访问
    public static synchronized LazySingletonSafeSynchronizedMethod getInstance(){
        if (singleton == null) {
            singleton = new LazySingletonSafeSynchronizedMethod();
        }
        return singleton;
    }

}
