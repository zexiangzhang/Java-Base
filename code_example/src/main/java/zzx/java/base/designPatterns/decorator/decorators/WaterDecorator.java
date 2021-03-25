package zzx.java.base.designPatterns.decorator.decorators;

import zzx.java.base.designPatterns.decorator.components.Eat;

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
