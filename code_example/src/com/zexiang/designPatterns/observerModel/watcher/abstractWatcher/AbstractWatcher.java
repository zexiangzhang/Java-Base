package com.zexiang.designPatterns.observerModel.watcher.abstractWatcher;

/**
 * 抽象的观察者
 */
public interface AbstractWatcher {

    /**
     * 观察者更新自身
     */
    void updateMyself(String message);

    /**
     * 获取观察者的名称； 实际业务中可以用sessionId等来做标识
     * @return
     */
    String getName();
}
