# Decorator

**Decorator** is a structural design pattern that **lets you attach new behaviors to objects by placing these objects inside special wrapper objects that contain the behaviors**.

The decorator class has the same interface as the original class and can add or override its behavior. The decorator class also maintains a reference to the original class, allowing it to forward calls to the original object.

## Example

Let's say we have an **`IceCream`** interface that has a **`getDescription()`** method to describe the ice cream and a **`getCost()`** method to get the cost of the ice cream. We can then create concrete classes that implement the **`IceCream`** interface, such as **`VanillaIceCream`** and **`ChocolateIceCream`**.

Now, let's say we want to add some extra toppings to the ice cream such as chocolate chips, sprinkles, etc. We can use the decorator pattern to add these toppings dynamically at runtime.

Here's the implementation:

```java
// Component Interface
interface IceCream {
    double getCost();
    String getDescription();
}

// Concrete Component Classes
class VanillaIceCream implements IceCream {

    @Override
    public double getCost() {
        return 2.0;
    }

    @Override
    public String getDescription() {
        return "Vanilla Ice Cream";
    }
}

class ChocolateIceCream implements IceCream {

    @Override
    public double getCost() {
        return 2.5;
    }

    @Override
    public String getDescription() {
        return "Chocolate Ice Cream";
    }
}

// Decorator Classes
abstract class IceCreamToppingsDecorator implements IceCream {
    protected IceCream iceCream;

    public IceCreamToppingsDecorator(IceCream iceCream) {
        this.iceCream = iceCream;
    }

    public abstract double getCost();
    public abstract String getDescription();
}

class ChocolateChipsDecorator extends IceCreamToppingsDecorator {

    public ChocolateChipsDecorator(IceCream iceCream) {
        super(iceCream);
    }

    @Override
    public double getCost() {
        return this.iceCream.getCost() + 0.5;
    }

    @Override
    public String getDescription() {
        return this.iceCream.getDescription() + " with Chocolate Chips";
    }
}

class SprinklesDecorator extends IceCreamToppingsDecorator {

    public SprinklesDecorator(IceCream iceCream) {
        super(iceCream);
    }

    @Override
    public double getCost() {
        return this.iceCream.getCost() + 0.3;
    }

    @Override
    public String getDescription() {
        return this.iceCream.getDescription() + " with Sprinkles";
    }
}

```

In the above code, **`IceCream`** is the component interface, **`VanillaIceCream`** and **`ChocolateIceCream`** are the concrete component classes, and **`IceCreamToppingsDecorator`**, **`ChocolateChipsDecorator`**, and **`SprinklesDecorator`** are the decorator classes.

We can create an instance of **`VanillaIceCream`** or **`ChocolateIceCream`**, and then wrap it with any number of decorators such as **`ChocolateChipsDecorator`** or **`SprinklesDecorator`** to add the desired toppings dynamically at runtime.

Here's an example:

```java
IceCream iceCream1 = new VanillaIceCream();
iceCream1 = new ChocolateChipsDecorator(iceCream1);
iceCream1 = new SprinklesDecorator(iceCream1);
System.out.println("Description: " + iceCream1.getDescription() + ", Cost: " + iceCream1.getCost());

IceCream iceCream2 = new ChocolateIceCream();
iceCream2 = new SprinklesDecorator(iceCream2);
System.out.println("Description: " + iceCream2.getDescription() + ", Cost: " + iceCream2.getCost());

```

Output:

```
Description: Vanilla Ice Cream with Chocolate Chips with Sprinkles, Cost: 3.3
Description: Chocolate Ice Cream with Sprinkles, Cost:
```

## Pros

- It **allows for the addition of functionality to an object dynamically, without modifying its original code.**
    - Example: The decorator pattern allows for adding or removing toppings to an ice cream without modifying the original ice cream object or creating a new subclass for every possible combination of ice cream and toppings.
- It **follows the open/closed principle**, which means that it is possible to add new decorators without affecting the existing code.
- It **allows for a high degree of flexibility and customizatio**n, as different decorators can be combined in various ways to achieve different effects.
- It **promotes single responsibility principl**e, which means that the responsibilities are divided among the decorator and the decorated object.

## Cons

- **It can result in a large number of small classes**, as each decorator class is responsible for adding a specific feature to the object.
    - Example: Using the decorator pattern can add some complexity to the code, particularly if there are many different types of objects to decorate.
- It **can be difficult to remove a specific feature once it has been added**, as it may require removing multiple decorators.
- It **can lead to complex code**, as decorators can be stacked on top of one another, making it difficult to understand the overall behavior of the object.