package com.zexiang.designPatterns.singleton.lazySingleton;

/**
 * 懒汉模式
 * 线程安全
 * 同步延迟加载
 * synchronized块
 */
public class LazySingletonSafeSynchronizedBlock {

    private static LazySingletonSafeSynchronizedBlock singleton;

    private LazySingletonSafeSynchronizedBlock(){}

    public static LazySingletonSafeSynchronizedBlock getInstance(){
        // 使用 synchronized 块，临界资源的同步互斥访问
        synchronized(LazySingletonSafeSynchronizedBlock.class){
            if (singleton == null) {
                singleton = new LazySingletonSafeSynchronizedBlock();
            }
        }
        return singleton;
    }

}
