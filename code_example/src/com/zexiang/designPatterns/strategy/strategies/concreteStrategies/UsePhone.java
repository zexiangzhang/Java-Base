package com.zexiang.designPatterns.strategy.strategies.concreteStrategies;

import com.zexiang.designPatterns.strategy.strategies.abstractStrategy.ContactStrategy;

public class UsePhone implements ContactStrategy {

    @Override
    public void contact() {
        System.out.println("电话联系");
    }
}
