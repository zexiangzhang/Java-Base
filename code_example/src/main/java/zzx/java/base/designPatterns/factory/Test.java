package zzx.java.base.designPatterns.factory;

import zzx.java.base.designPatterns.factory.factories.abstractFactory.factories.abstractFactories.TyreAndWheelFactory;
import zzx.java.base.designPatterns.factory.factories.abstractFactory.factories.concreteFactories.CadillacTyreAndWheelFactory;
import zzx.java.base.designPatterns.factory.factories.factoryMethod.CarMethodFactory;
import zzx.java.base.designPatterns.factory.factories.factoryMethod.implFactories.CadillacFactory;
import zzx.java.base.designPatterns.factory.factories.simpleFactory.CarSimpleFactory;

public class Test {


    public static void main(String[] args) {
        // 简单工厂模式
        CarSimpleFactory simpleFactory = new CarSimpleFactory();
        simpleFactory.getCar("cadillac");

        //工厂方法模式
        CarMethodFactory methodFactory = new CadillacFactory();
        methodFactory.run();

        //抽象模式
        TyreAndWheelFactory abstractFactory = new CadillacTyreAndWheelFactory();
        abstractFactory.createTyre().run();
        abstractFactory.createWheel().control();
    }
}
