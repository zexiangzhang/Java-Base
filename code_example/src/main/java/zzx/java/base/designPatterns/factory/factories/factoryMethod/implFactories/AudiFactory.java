package zzx.java.base.designPatterns.factory.factories.factoryMethod.implFactories;

import zzx.java.base.designPatterns.factory.cars.Audi;
import zzx.java.base.designPatterns.factory.factories.factoryMethod.CarMethodFactory;
import zzx.java.base.designPatterns.factory.interfaces.CommonCar;

public class AudiFactory implements CarMethodFactory {

    @Override
    public CommonCar run() {
        return new Audi();
    }
}
