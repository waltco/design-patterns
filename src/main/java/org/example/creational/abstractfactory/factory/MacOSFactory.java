package org.example.creational.abstractfactory.factory;

import org.example.creational.abstractfactory.window.MacOSWindow;
import org.example.creational.abstractfactory.window.Window;
import org.example.creational.abstractfactory.button.Button;
import org.example.creational.abstractfactory.button.MacOSButton;

public class MacOSFactory extends AbstractFactory {
    @Override
    public Window createWindow() {
        return new MacOSWindow();
    }

    @Override
    public Button createButton() {
        return new MacOSButton();
    }
}
