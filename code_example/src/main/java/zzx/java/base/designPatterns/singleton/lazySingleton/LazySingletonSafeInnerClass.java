package zzx.java.base.designPatterns.singleton.lazySingleton;

/**
 * 懒汉模式
 * 同步延迟加载
 * 内部类
 */
public class LazySingletonSafeInnerClass {

    // 私有内部类，按需加载，用时加载，也就是延迟加载
    private static class Holder {
        private static LazySingletonSafeInnerClass singleton = new LazySingletonSafeInnerClass();
    }

    private LazySingletonSafeInnerClass() {}

    public static LazySingletonSafeInnerClass getInstance() {
        return Holder.singleton;
    }
}
