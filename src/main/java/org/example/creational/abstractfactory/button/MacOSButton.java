package org.example.creational.abstractfactory.button;

import org.example.creational.abstractfactory.button.Button;

public class MacOSButton implements Button {
    @Override
    public void click() {
        System.out.println("Clicked a MacOS button");
    }
}
