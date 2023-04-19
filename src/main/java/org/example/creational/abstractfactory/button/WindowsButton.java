package org.example.creational.abstractfactory.button;

public class WindowsButton implements Button {
    @Override
    public void click() {
        System.out.println("Clicked a Windows button");
    }
}
