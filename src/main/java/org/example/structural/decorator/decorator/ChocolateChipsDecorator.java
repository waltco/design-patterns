package org.example.structural.decorator.decorator;

import org.example.structural.decorator.IceCream;

public class ChocolateChipsDecorator extends IceCreamToppingsDecorator {

    public ChocolateChipsDecorator(IceCream iceCream) {
        super(iceCream);
    }

    @Override
    public double getCost() {
        return this.iceCream.getCost() + 0.5;
    }

    @Override
    public String getDescription() {
        return this.iceCream.getDescription() + " with Chocolate Chips";
    }
}
