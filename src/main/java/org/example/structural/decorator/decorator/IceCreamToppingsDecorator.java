package org.example.structural.decorator.decorator;

import org.example.structural.decorator.IceCream;

abstract class IceCreamToppingsDecorator implements IceCream {
    protected IceCream iceCream;

    public IceCreamToppingsDecorator(IceCream iceCream) {
        this.iceCream = iceCream;
    }

}
