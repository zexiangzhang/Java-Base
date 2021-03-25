package zzx.java.base.designPatterns.factory.factories.simpleFactory;

import zzx.java.base.designPatterns.factory.cars.Audi;
import zzx.java.base.designPatterns.factory.cars.Cadillac;
import zzx.java.base.designPatterns.factory.interfaces.CommonCar;

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
