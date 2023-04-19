package org.example.creational.abstractfactory.window;

public class WindowsWindow implements Window {

    @Override
    public void paint() {
        System.out.println("Painting a Windows window");
    }
}
