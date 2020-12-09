package com.zexiang.designPatterns.adapter.interfaceAdapter;

import com.zexiang.designPatterns.adapter.interfaceAdapter.target.Target;

public class Test {

    public static void main(String[] args) {
        Target target = new Target();
        target.love();
        target.eat();
        target.dance();
    }

}
