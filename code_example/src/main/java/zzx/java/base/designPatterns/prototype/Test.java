package zzx.java.base.designPatterns.prototype;

import zzx.java.base.designPatterns.prototype.concretePrototype.ConcretePrototype;

public class Test {

    public static void main(String[] args) {

        ConcretePrototype sourcePrototype = new ConcretePrototype();

        sourcePrototype.setFieldKey("抽象原型key");
        sourcePrototype.setFieldValue("抽象原型value");

        int num = 3;

        while (num > 0) {
            ConcretePrototype concretePrototype  = (ConcretePrototype) sourcePrototype.clone();

            concretePrototype.setFieldKey("具体原型key" + num);
            concretePrototype.setFieldValue("具体原型value" + num);

            concretePrototype.show();

            num --;
        }
    }

}
