package org.example.creational.abstractfactory.window;

public class MacOSWindow implements Window {

    @Override
    public void paint() {
        System.out.println("Painting a MacOS window");
    }
}
