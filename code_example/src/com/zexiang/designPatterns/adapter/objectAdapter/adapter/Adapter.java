package com.zexiang.designPatterns.adapter.objectAdapter.adapter;

import com.zexiang.designPatterns.adapter.objectAdapter.adaptee.Adaptee;
import com.zexiang.designPatterns.adapter.objectAdapter.target.Target;

/**
 * 适配器
 */
public class Adapter implements Target {

    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void method1() {
        adaptee.method1();
    }

    @Override
    public void method2() {
        System.out.println("这是个两个插头");
    }
}
