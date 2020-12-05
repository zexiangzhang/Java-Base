package com.zexiang.designPatterns.factory;

import com.zexiang.designPatterns.factory.factories.abstractFactory.factories.abstractFactories.TyreAndWheelFactory;
import com.zexiang.designPatterns.factory.factories.abstractFactory.factories.concreteFactories.CadillacTyreAndWheelFactory;
import com.zexiang.designPatterns.factory.factories.factoryMethod.CarMethodFactory;
import com.zexiang.designPatterns.factory.factories.factoryMethod.implFactories.CadillacFactory;
import com.zexiang.designPatterns.factory.factories.simpleFactory.CarSimpleFactory;

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
