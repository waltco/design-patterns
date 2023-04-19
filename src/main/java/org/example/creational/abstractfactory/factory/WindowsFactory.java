package org.example.creational.abstractfactory.factory;

import org.example.creational.abstractfactory.window.Window;
import org.example.creational.abstractfactory.window.WindowsWindow;
import org.example.creational.abstractfactory.button.Button;
import org.example.creational.abstractfactory.button.WindowsButton;

public class WindowsFactory extends AbstractFactory {
    @Override
    public Window createWindow() {
        return new WindowsWindow();
    }

    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
