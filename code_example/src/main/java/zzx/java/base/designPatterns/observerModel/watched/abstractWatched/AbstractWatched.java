package zzx.java.base.designPatterns.observerModel.watched.abstractWatched;

import zzx.java.base.designPatterns.observerModel.watcher.abstractWatcher.AbstractWatcher;

/**
 * 抽象的被观察者
 */
public interface AbstractWatched {

    /**
     * 添加观察自己的人
     * @param watcher
     */
    void addWatcher(AbstractWatcher watcher);

    /**
     * 删除观察自己的人，即不让谁观察了
     * @param watcher
     */
    void removeWatcher(AbstractWatcher watcher);

    /**
     * 当自己有改变时通知观察自己的人
     * @param updateContent
     */
    void notifyWatchers(String updateContent);

}
