package com.zexiang.designPatterns.strategy.strategies.concreteStrategies;

import com.zexiang.designPatterns.strategy.strategies.abstractStrategy.ContactStrategy;

public class UseLetter implements ContactStrategy {

    @Override
    public void contact() {
        System.out.println("写信联系");
    }
}
