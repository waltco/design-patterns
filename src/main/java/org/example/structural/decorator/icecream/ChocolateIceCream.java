package org.example.structural.decorator.icecream;

import org.example.structural.decorator.IceCream;

public class ChocolateIceCream implements IceCream {
    @Override
    public double getCost() {
        return 2.5;
    }

    @Override
    public String getDescription() {
        return "Chocolate Ice Cream";
    }

}
