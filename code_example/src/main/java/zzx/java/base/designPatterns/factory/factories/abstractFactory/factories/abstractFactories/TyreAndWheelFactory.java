package zzx.java.base.designPatterns.factory.factories.abstractFactory.factories.abstractFactories;

import zzx.java.base.designPatterns.factory.factories.abstractFactory.products.abstracProducts.Tyre;
import zzx.java.base.designPatterns.factory.factories.abstractFactory.products.abstracProducts.Wheel;

/**
 * 抽象工厂
 */
public interface TyreAndWheelFactory {

    Tyre createTyre();

    Wheel createWheel();
}
