package org.example.creational.factory;

public class Main {

    public static void main(String[] args) {
        Shape triangle = new ShapeFactory().getShape("triangle");
        triangle.draw();
        Shape circle = new ShapeFactory().getShape("circle");
        circle.draw();
    }
}
