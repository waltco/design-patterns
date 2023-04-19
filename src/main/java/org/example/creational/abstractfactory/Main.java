package org.example.creational.abstractfactory;

import org.example.creational.abstractfactory.factory.AbstractFactory;
import org.example.creational.abstractfactory.factory.OperativeSystem;

public class Main {

    public static void main(String[] args) {
        AbstractFactory factoryMacOS = AbstractFactory.getFactory(OperativeSystem.MACOS);
        factoryMacOS.createWindow().paint();
        factoryMacOS.createButton().click();

        AbstractFactory factoryWindows = AbstractFactory.getFactory(OperativeSystem.WINDOWS);
        factoryWindows.createWindow().paint();
        factoryWindows.createButton().click();
    }
}
