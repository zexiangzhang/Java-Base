package zzx.java.base.designPatterns.observerModel.watcher.concreteWatcher;

import zzx.java.base.designPatterns.observerModel.watcher.abstractWatcher.AbstractWatcher;

/**
 * 具体观察者A
 */
public class ConcreteWatcherB implements AbstractWatcher {

    @Override
    public void updateMyself(String message) {
        System.out.println("观察者B接收到被观察者的消息 ：" + message);
    }

    @Override
    public String getName() {
        return "观察者B";
    }
}
