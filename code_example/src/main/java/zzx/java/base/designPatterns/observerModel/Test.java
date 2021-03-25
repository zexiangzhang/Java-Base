package zzx.java.base.designPatterns.observerModel;

import zzx.java.base.designPatterns.observerModel.watched.abstractWatched.AbstractWatched;
import zzx.java.base.designPatterns.observerModel.watched.concreteWatched.ConcreteWatchedA;
import zzx.java.base.designPatterns.observerModel.watcher.abstractWatcher.AbstractWatcher;
import zzx.java.base.designPatterns.observerModel.watcher.concreteWatcher.ConcreteWatcherA;
import zzx.java.base.designPatterns.observerModel.watcher.concreteWatcher.ConcreteWatcherB;

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
