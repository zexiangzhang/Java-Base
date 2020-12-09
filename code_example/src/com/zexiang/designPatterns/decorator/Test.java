package com.zexiang.designPatterns.decorator;

import com.zexiang.designPatterns.decorator.components.Eat;
import com.zexiang.designPatterns.decorator.components.ZzxEat;
import com.zexiang.designPatterns.decorator.decorators.SaltDecorator;
import com.zexiang.designPatterns.decorator.decorators.WaterDecorator;

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
