package zzx.java.base.designPatterns.factory.factories.factoryMethod;

import zzx.java.base.designPatterns.factory.interfaces.CommonCar;

/**
 * 工厂方法模式
 */
public interface CarMethodFactory {

    // 行驶
    CommonCar run();

}
