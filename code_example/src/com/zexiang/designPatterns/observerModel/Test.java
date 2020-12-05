package com.zexiang.designPatterns.observerModel;

import com.zexiang.designPatterns.observerModel.watched.abstractWatched.AbstractWatched;
import com.zexiang.designPatterns.observerModel.watched.concreteWatched.ConcreteWatchedA;
import com.zexiang.designPatterns.observerModel.watcher.abstractWatcher.AbstractWatcher;
import com.zexiang.designPatterns.observerModel.watcher.concreteWatcher.ConcreteWatcherA;
import com.zexiang.designPatterns.observerModel.watcher.concreteWatcher.ConcreteWatcherB;

public class Test {

    public static void main(String[] args) {
        //实例化被观察者
        AbstractWatched watched = new ConcreteWatchedA("被观察者A");

        //实例化观察者
        AbstractWatcher watcherA = new ConcreteWatcherA();
        AbstractWatcher watcherB = new ConcreteWatcherB();

        watched.addWatcher(watcherA);
        watched.addWatcher(watcherB);

        watched.notifyWatchers("今晚红浪漫不？");

    }
}
