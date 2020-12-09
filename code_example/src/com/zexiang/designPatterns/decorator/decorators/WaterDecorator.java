package com.zexiang.designPatterns.decorator.decorators;

import com.zexiang.designPatterns.decorator.components.Eat;

/**
 * 具体的加盐的装饰器
 */
public class WaterDecorator extends Decorator{

    public WaterDecorator(Eat eat) {
        super(eat);
    }

    @Override
    public String eat() {
        return super.eat() + "  加点水";
    }
}
