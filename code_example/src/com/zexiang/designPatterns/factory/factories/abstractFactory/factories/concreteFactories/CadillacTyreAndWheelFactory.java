package com.zexiang.designPatterns.factory.factories.abstractFactory.factories.concreteFactories;

import com.zexiang.designPatterns.factory.factories.abstractFactory.products.abstracProducts.Tyre;
import com.zexiang.designPatterns.factory.factories.abstractFactory.products.abstracProducts.Wheel;
import com.zexiang.designPatterns.factory.factories.abstractFactory.factories.abstractFactories.TyreAndWheelFactory;
import com.zexiang.designPatterns.factory.factories.abstractFactory.products.concreteProducts.CadillacTyre;
import com.zexiang.designPatterns.factory.factories.abstractFactory.products.concreteProducts.CadillacWheel;

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
