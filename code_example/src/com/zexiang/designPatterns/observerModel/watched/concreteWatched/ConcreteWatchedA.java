package com.zexiang.designPatterns.observerModel.watched.concreteWatched;

import com.zexiang.designPatterns.observerModel.watched.abstractWatched.AbstractWatched;
import com.zexiang.designPatterns.observerModel.watcher.abstractWatcher.AbstractWatcher;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CountDownLatch;

/**
 * 具体的被观察者
 */
public class ConcreteWatchedA implements AbstractWatched {

    private String name;

    private ConcurrentMap<String, AbstractWatcher> watchers;

    public ConcreteWatchedA(String name) {
        this.name = name;
        watchers = new ConcurrentHashMap<>();
    }

    @Override
    public void addWatcher(AbstractWatcher watcher) {
        watchers.put(watcher.getName(), watcher);
    }

    @Override
    public void removeWatcher(AbstractWatcher watcher) {
        watchers.remove(watcher.getName());
    }

    @Override
    public void notifyWatchers(String updateContent) {
        try {
            CountDownLatch latch = new CountDownLatch(watchers.size());
            if (watchers.keySet().size() > 0) {
                watchers.keySet().forEach(o  -> watchers.get(o).updateMyself(updateContent));
            }
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
