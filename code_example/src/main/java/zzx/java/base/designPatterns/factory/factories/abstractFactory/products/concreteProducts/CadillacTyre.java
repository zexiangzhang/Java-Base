package zzx.java.base.designPatterns.factory.factories.abstractFactory.products.concreteProducts;

import zzx.java.base.designPatterns.factory.factories.abstractFactory.products.abstracProducts.Tyre;

/**
 * 凯迪拉克轮胎
 */
public class CadillacTyre implements Tyre {

    @Override
    public void run() {
        System.out.println("凯迪拉克轮胎");
    }
}
