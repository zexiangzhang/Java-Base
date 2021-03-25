package zzx.java.base.designPatterns.strategy;

import zzx.java.base.designPatterns.strategy.context.ContactContext;
import zzx.java.base.designPatterns.strategy.strategies.concreteStrategies.UseHeart;

public class Test {

    public static void main(String[] args) {
        ContactContext context = new ContactContext();

        context.setStrategy(new UseHeart());

        context.contact();
    }
}
