package com.zexiang.designPatterns.singleton.lazySingleton;

/**
 * 懒汉模式
 * 延迟加载
 * 线程不安全
 */
public class LazySingleton {

    // 指向自己实例的私有静态引用
    private static LazySingleton singleton;

    // 私有的构造方法
    private LazySingleton(){}

    // 以自己实例为返回值的静态的公有方法，静态工厂方法
    public static LazySingleton getInstance(){
        // 被动创建，在真正需要使用时才去创建
        if (singleton == null) {
            singleton = new LazySingleton();
        }
        return singleton;
    }
}
