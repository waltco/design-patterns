package org.example.creational.factory;

public class ShapeFactory {

    Shape getShape(String type){
        if (type.equalsIgnoreCase("circle")) {
            return new Circle();
        } else if (type.equalsIgnoreCase("triangle")){
            return new Triangle();
        } else {
            return null;
        }
    }
}
