package com.zexiang.designPatterns.adapter.objectAdapter;

import com.zexiang.designPatterns.adapter.objectAdapter.adaptee.Adaptee;
import com.zexiang.designPatterns.adapter.objectAdapter.adapter.Adapter;

public class Test {

    public static void main(String[] args) {
        Adapter adapter = new Adapter(new Adaptee());
        adapter.method1();
        adapter.method2();
    }

}
