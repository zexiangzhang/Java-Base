package zzx.java.base.designPatterns.adapter.interfaceAdapter.target;

import zzx.java.base.designPatterns.adapter.interfaceAdapter.adapter.Adapter;

/**
 * 目标客户端
 */
public class Target extends Adapter {

    public void love() {
        System.out.println("我是某某某，我要专心谈恋爱");
    }

}
