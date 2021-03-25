package zzx.java.base.designPatterns.adapter.objectAdapter;

import zzx.java.base.designPatterns.adapter.objectAdapter.adaptee.Adaptee;
import zzx.java.base.designPatterns.adapter.objectAdapter.adapter.Adapter;

public class Test {

    public static void main(String[] args) {
        Adapter adapter = new Adapter(new Adaptee());
        adapter.method1();
        adapter.method2();
    }

}
