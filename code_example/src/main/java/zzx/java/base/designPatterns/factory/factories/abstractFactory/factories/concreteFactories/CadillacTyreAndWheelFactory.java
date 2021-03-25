package zzx.java.base.designPatterns.factory.factories.abstractFactory.factories.concreteFactories;

import zzx.java.base.designPatterns.factory.factories.abstractFactory.factories.abstractFactories.TyreAndWheelFactory;
import zzx.java.base.designPatterns.factory.factories.abstractFactory.products.abstracProducts.Tyre;
import zzx.java.base.designPatterns.factory.factories.abstractFactory.products.abstracProducts.Wheel;
import zzx.java.base.designPatterns.factory.factories.abstractFactory.products.concreteProducts.CadillacTyre;
import zzx.java.base.designPatterns.factory.factories.abstractFactory.products.concreteProducts.CadillacWheel;

/**
 * 凯迪拉克生产轮胎和方向盘的工厂类
 */
public class CadillacTyreAndWheelFactory implements TyreAndWheelFactory {

    @Override
    public Tyre createTyre() {
        return new CadillacTyre();
    }

    @Override
    public Wheel createWheel() {
        return new CadillacWheel();
    }
}
