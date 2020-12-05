package com.zexiang.designPatterns.singleton.hungerySingleton;

/**
 * 饿汉式单例模式
 * 立即加载，本身是线程安全的
 */
public class HungrySingleton {

    // 指向自己实例的私有静态引用，主动创建
    private static HungrySingleton singleton = new HungrySingleton();

    // 私有的构造方法
    private HungrySingleton(){}

    // 以自己实例为返回值的静态的公有方法，静态工厂方法
    public static HungrySingleton getInstance() {
        return singleton;
    }

}
