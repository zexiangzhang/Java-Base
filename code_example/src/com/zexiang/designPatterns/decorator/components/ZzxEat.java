package com.zexiang.designPatterns.decorator.components;

/**
 * 具体的组件（我自己吃）
 */
public class ZzxEat implements Eat{

    @Override
    public String eat() {
        return "简单吃饭";
    }
}
