package com.zexiang.designPatterns.adapter.interfaceAdapter.adapter;

import com.zexiang.designPatterns.adapter.interfaceAdapter.adaptee.Adaptee;
import com.zexiang.designPatterns.adapter.interfaceAdapter.target.Target;

/**
 * 适配器
 */
public abstract class Adapter implements Adaptee {

    @Override
    public void run() {}

    @Override
    public void dance() {}

    @Override
    public void eat() {
        System.out.println("我是接口适配器，我帮某某某平淡的吃饭，他去专心谈恋爱了(理论上这里应该是空实现，例如dance方法)");
    }

    @Override
    public void sleep() {}

    @Override
    public void love() {}
}
