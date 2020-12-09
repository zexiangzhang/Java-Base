package com.zexiang.designPatterns.decorator.decorators;

import com.zexiang.designPatterns.decorator.components.Eat;

/**
 * 具体的加盐的装饰器
 */
public class SaltDecorator extends Decorator{

    public SaltDecorator(Eat eat) {
        super(eat);
    }

    @Override
    public String eat() {
        return super.eat() + "  加点盐";
    }
}
