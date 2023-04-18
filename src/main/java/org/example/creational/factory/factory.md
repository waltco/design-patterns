# Factory Pattern

Factory Method **allows the creation of objects of a certain subtype through a Factory class**. This is especially **useful when we don't know, at design time, the subtype that we are going to use or when we want to delegate the logic of creating the objects to a Factory class**.

The Factory Pattern is useful **when the creation of an object is complex or requires specific conditions that need to be met.**

Here's an example of how the Factory Pattern can be implemented in Java:

```
public interface Shape {
    void draw();
}

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle.");
    }
}

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle.");
    }
}

public class ShapeFactory {
    public Shape createShape(String type) {
        if (type.equalsIgnoreCase("circle")) {
            return new Circle();
        } else if (type.equalsIgnoreCase("rectangle")) {
            return new Rectangle();
        } else {
            return null;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape circle = shapeFactory.createShape("circle");
        circle.draw();

        Shape rectangle = shapeFactory.createShape("rectangle");
        rectangle.draw();
    }
}

```

In this example, we have a `Shape` interface and two concrete classes that implement it: `Circle` and `Rectangle`. We also have a `ShapeFactory` class that has a `createShape()` method which takes a `String` parameter indicating the type of shape to create. Based on the type parameter, the factory method creates and returns the appropriate object.

In the `Main` class, we create an instance of the `ShapeFactory` and use it to create a `Circle` and a `Rectangle` object. The `draw()` method of each object is then called, resulting in the appropriate message being printed to the console.

This implementation of the Factory Pattern provides a way to create different types of `Shape` objects without exposing the creation logic to the client. It also encapsulates the creation logic in a separate class, making it easier to maintain and modify in the future.