package com.zexiang.designPatterns.factory.factories.simpleFactory;

import com.zexiang.designPatterns.factory.cars.Audi;
import com.zexiang.designPatterns.factory.cars.Cadillac;
import com.zexiang.designPatterns.factory.interfaces.CommonCar;

import java.util.Objects;

/**
 * 简单工厂
 */
public class CarSimpleFactory {

    public CommonCar getCar(String carType) {
        CommonCar car = null;
        if (Objects.equals("audi", carType)) {
            car = new Audi();
        } else if(Objects.equals("cadillac", carType)){
            car = new Cadillac();
        }
        if(Objects.nonNull(car)){
            car.run();
        }
        return car;
    }

}
