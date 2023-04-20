package org.example.structural.decorator.decorator;

import org.example.structural.decorator.IceCream;

public class SprinklesDecorator extends IceCreamToppingsDecorator {

    public SprinklesDecorator(IceCream iceCream) {
        super(iceCream);
    }

    @Override
    public double getCost() {
        return this.iceCream.getCost() + 0.3;
    }

    @Override
    public String getDescription() {
        return this.iceCream.getDescription() + " with Sprinkles";
    }
}
