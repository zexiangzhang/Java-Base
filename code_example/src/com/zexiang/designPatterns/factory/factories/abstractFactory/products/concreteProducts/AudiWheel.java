package com.zexiang.designPatterns.factory.factories.abstractFactory.products.concreteProducts;

import com.zexiang.designPatterns.factory.factories.abstractFactory.products.abstracProducts.Wheel;

/**
 * 奥迪方向盘
 */
public class AudiWheel implements Wheel {

    @Override
    public void control() {
        System.out.println("奥迪方向盘");
    }
}
