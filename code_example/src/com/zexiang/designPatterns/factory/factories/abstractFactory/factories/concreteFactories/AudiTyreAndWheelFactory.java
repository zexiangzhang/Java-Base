package com.zexiang.designPatterns.factory.factories.abstractFactory.factories.concreteFactories;

import com.zexiang.designPatterns.factory.factories.abstractFactory.products.abstracProducts.Tyre;
import com.zexiang.designPatterns.factory.factories.abstractFactory.products.abstracProducts.Wheel;
import com.zexiang.designPatterns.factory.factories.abstractFactory.factories.abstractFactories.TyreAndWheelFactory;
import com.zexiang.designPatterns.factory.factories.abstractFactory.products.concreteProducts.AudiTyre;
import com.zexiang.designPatterns.factory.factories.abstractFactory.products.concreteProducts.AudiWheel;

/**
 * 奥迪生产轮胎和方向盘的工厂类
 */
public class AudiTyreAndWheelFactory implements TyreAndWheelFactory {

    @Override
    public Tyre createTyre() {
        return new AudiTyre();
    }

    @Override
    public Wheel createWheel() {
        return new AudiWheel();
    }
}
