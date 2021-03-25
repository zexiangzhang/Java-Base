package zzx.java.base.designPatterns.adapter.classAdapter.adapter;

import zzx.java.base.designPatterns.adapter.classAdapter.adaptee.Adaptee;
import zzx.java.base.designPatterns.adapter.classAdapter.target.Target;

/**
 * 适配器（继承源内部的三孔，适配器实现两孔）
 */
public class Adapter extends Adaptee implements Target {

    @Override
    public void method2() {
        System.out.println("这是个两个插头");
    }
}
