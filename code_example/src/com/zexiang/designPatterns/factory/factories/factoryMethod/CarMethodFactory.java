package com.zexiang.designPatterns.factory.factories.factoryMethod;

import com.zexiang.designPatterns.factory.interfaces.CommonCar;

/**
 * 工厂方法模式
 */
public interface CarMethodFactory {

    // 行驶
    public CommonCar run();

}
