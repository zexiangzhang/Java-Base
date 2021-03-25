package zzx.java.base.designPatterns.factory.factories.abstractFactory.products.concreteProducts;

import zzx.java.base.designPatterns.factory.factories.abstractFactory.products.abstracProducts.Wheel;

/**
 * 凯迪拉克方向盘
 */
public class CadillacWheel implements Wheel {

    @Override
    public void control() {
        System.out.println("凯迪拉克方向盘");
    }
}
