package org.example.structural.decorator.icecream;

import org.example.structural.decorator.IceCream;

public class VanillaIceCream implements IceCream {
    @Override
    public double getCost() {
        return 2.0;
    }

    @Override
    public String getDescription() {
        return "Vanilla Ice Cream";
    }
}
