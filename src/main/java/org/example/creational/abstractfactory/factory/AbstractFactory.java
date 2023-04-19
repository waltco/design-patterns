package org.example.creational.abstractfactory.factory;

import org.example.creational.abstractfactory.button.Button;
import org.example.creational.abstractfactory.window.Window;

public abstract class AbstractFactory {

    public static AbstractFactory getFactory(OperativeSystem operativeSystem) {
        return switch (operativeSystem) {
            case WINDOWS -> new WindowsFactory();
            case MACOS -> new MacOSFactory();
        };
    }
    public abstract Window createWindow();
    public abstract Button createButton();

}
