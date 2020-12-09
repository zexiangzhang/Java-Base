package com.zexiang.designPatterns.strategy.strategies.concreteStrategies;

import com.zexiang.designPatterns.strategy.strategies.abstractStrategy.ContactStrategy;

public class UseHeart implements ContactStrategy {

    @Override
    public void contact() {
        System.out.println("心灵沟通");
    }
}
