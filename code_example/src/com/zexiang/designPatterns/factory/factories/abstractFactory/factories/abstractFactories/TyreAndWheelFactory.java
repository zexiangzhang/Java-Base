package com.zexiang.designPatterns.factory.factories.abstractFactory.factories.abstractFactories;

import com.zexiang.designPatterns.factory.factories.abstractFactory.products.abstracProducts.Tyre;
import com.zexiang.designPatterns.factory.factories.abstractFactory.products.abstracProducts.Wheel;

/**
 * 抽象工厂
 */
public interface TyreAndWheelFactory {

    Tyre createTyre();

    Wheel createWheel();
}
