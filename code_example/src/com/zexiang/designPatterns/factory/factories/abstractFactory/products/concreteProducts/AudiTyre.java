package com.zexiang.designPatterns.factory.factories.abstractFactory.products.concreteProducts;

import com.zexiang.designPatterns.factory.factories.abstractFactory.products.abstracProducts.Tyre;

/**
 * 奥迪轮胎
 */
public class AudiTyre implements Tyre {

    @Override
    public void run() {
        System.out.println("奥迪轮胎");
    }
}
