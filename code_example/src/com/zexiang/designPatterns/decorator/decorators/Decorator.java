package com.zexiang.designPatterns.decorator.decorators;

import com.zexiang.designPatterns.decorator.components.Eat;

/**
 * 抽线的，实现了顶级（吃饭）组件的装饰器
 */
public class Decorator implements Eat {

    protected final Eat decoratorEat;

    public Decorator(Eat eat) {
        decoratorEat = eat;
    }

    @Override
    public String eat() {
        return decoratorEat.eat();
    }
}
