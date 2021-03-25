package zzx.java.base.designPatterns.decorator;

import zzx.java.base.designPatterns.decorator.components.Eat;
import zzx.java.base.designPatterns.decorator.components.ZzxEat;
import zzx.java.base.designPatterns.decorator.decorators.SaltDecorator;
import zzx.java.base.designPatterns.decorator.decorators.WaterDecorator;

public class Test {

    public static void main(String[] args) {

        Eat eat = new ZzxEat();
        System.out.println(eat.eat());

        Eat saltEat = new SaltDecorator(eat);
        System.out.println(saltEat.eat());

        Eat waterEat = new WaterDecorator(eat);
        System.out.println(waterEat.eat());
    }

}
