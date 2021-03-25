package zzx.java.base.designPatterns.strategy.context;

import zzx.java.base.designPatterns.strategy.strategies.abstractStrategy.ContactStrategy;

public class ContactContext {

    private ContactStrategy strategy;

    public void setStrategy(ContactStrategy strategy)  {this.strategy = strategy;}

    public void contact() {
        strategy.contact();
    }
}
