package com.zexiang.designPatterns.adapter.classAdapter;

import com.zexiang.designPatterns.adapter.classAdapter.adapter.Adapter;

public class Test {

    public static void main(String[] args) {
        Adapter adapter = new Adapter();
        adapter.method1();
        adapter.method2();
    }

}
