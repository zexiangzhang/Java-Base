package zzx.java.base.designPatterns.decorator.decorators;

import zzx.java.base.designPatterns.decorator.components.Eat;

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
