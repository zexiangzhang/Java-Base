package com.zexiang.designPatterns.factory.cars;

import com.zexiang.designPatterns.factory.interfaces.CommonCar;

/**
 * 奥迪
 */
public class Audi implements CommonCar {

    @Override
    public void run() {
        System.out.println("奥迪A6L， 呜呜呜......");
    }
}
