package com.zexiang.designPatterns.strategy.context;

import com.zexiang.designPatterns.strategy.strategies.abstractStrategy.ContactStrategy;

public class ContactContext {

    private ContactStrategy strategy;

    public void setStrategy(ContactStrategy strategy)  {this.strategy = strategy;}

    public void contact() {
        strategy.contact();
    }
}
