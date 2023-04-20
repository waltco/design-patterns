package org.example.structural.decorator;

import org.example.structural.decorator.decorator.ChocolateChipsDecorator;
import org.example.structural.decorator.decorator.SprinklesDecorator;
import org.example.structural.decorator.icecream.ChocolateIceCream;
import org.example.structural.decorator.icecream.VanillaIceCream;

public class Main {
    public static void main(String[] args) {
        IceCream iceCream1 = new VanillaIceCream();
        iceCream1 = new ChocolateChipsDecorator(iceCream1);
        iceCream1 = new SprinklesDecorator(iceCream1);
        System.out.println("Description: " + iceCream1.getDescription() + ", Cost: " + iceCream1.getCost());

        IceCream iceCream2 = new ChocolateIceCream();
        iceCream2 = new SprinklesDecorator(iceCream2);
        System.out.println("Description: " + iceCream2.getDescription() + ", Cost: " + iceCream2.getCost());
    }
}
