package com.zexiang.designPatterns.prototype.concretePrototype;

import com.zexiang.designPatterns.prototype.abstractPrototype.AbstractPrototype;

/**
 * 具体原型
 */
public class ConcretePrototype extends AbstractPrototype {

    public ConcretePrototype() {
        System.out.println("具体原型的构造方法");
    }

    public void show() {
        System.out.println("filed key is : " + this.getFieldKey() + "      filed value is : " + this.getFieldValue());
    }
}
