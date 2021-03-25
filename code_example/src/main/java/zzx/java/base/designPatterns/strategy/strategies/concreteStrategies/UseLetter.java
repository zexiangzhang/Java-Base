package zzx.java.base.designPatterns.strategy.strategies.concreteStrategies;

import zzx.java.base.designPatterns.strategy.strategies.abstractStrategy.ContactStrategy;

public class UseLetter implements ContactStrategy {

    @Override
    public void contact() {
        System.out.println("写信联系");
    }
}
