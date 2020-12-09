package com.zexiang.designPatterns.strategy;

import com.zexiang.designPatterns.strategy.context.ContactContext;
import com.zexiang.designPatterns.strategy.strategies.concreteStrategies.UseHeart;

public class Test {

    public static void main(String[] args) {
        ContactContext context = new ContactContext();

        context.setStrategy(new UseHeart());

        context.contact();
    }
}
