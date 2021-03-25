package zzx.java.base.designPatterns.strategy.strategies.concreteStrategies;

import zzx.java.base.designPatterns.strategy.strategies.abstractStrategy.ContactStrategy;

public class UsePhone implements ContactStrategy {

    @Override
    public void contact() {
        System.out.println("电话联系");
    }
}
