package com.zexiang.designPatterns.factory.cars;

import com.zexiang.designPatterns.factory.interfaces.CommonCar;

/**
 * 凯迪拉克
 */
public class Cadillac implements CommonCar {

    @Override
    public void run() {
        System.out.println("老规矩，红浪漫，16号技师......");
    }
}
