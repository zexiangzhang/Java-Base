package com.zexiang.designPatterns.factory.factories.factoryMethod.implFactories;

import com.zexiang.designPatterns.factory.cars.Audi;
import com.zexiang.designPatterns.factory.factories.factoryMethod.CarMethodFactory;
import com.zexiang.designPatterns.factory.interfaces.CommonCar;

public class AudiFactory implements CarMethodFactory {

    @Override
    public CommonCar run() {
        return new Audi();
    }
}
