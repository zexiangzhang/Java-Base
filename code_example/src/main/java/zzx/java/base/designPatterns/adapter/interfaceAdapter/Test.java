package zzx.java.base.designPatterns.adapter.interfaceAdapter;

import zzx.java.base.designPatterns.adapter.interfaceAdapter.target.Target;

public class Test {

    public static void main(String[] args) {
        Target target = new Target();
        target.love();
        target.eat();
        target.dance();
    }

}
