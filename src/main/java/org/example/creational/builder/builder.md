# Builder Pattern

The builder pattern is a design pattern that **enables the creation of complex objects through a step-by-step approach**, **allowing for more control over the creation process** and avoiding the need for a large number of constructor parameters.

Here is an example of implementing the builder pattern with Java:

```
public class Pizza {
    private final String crust;
    private final String sauce;
    private final List<String> toppings;

    private Pizza(Builder builder) {
        this.crust = builder.crust;
        this.sauce = builder.sauce;
        this.toppings = builder.toppings;
    }

    public static class Builder {
        private final String crust;
        private final String sauce;
        private final List<String> toppings;

        public Builder(String crust, String sauce) {
            this.crust = crust;
            this.sauce = sauce;
            this.toppings = new ArrayList<>();
        }

        public Builder addTopping(String topping) {
            toppings.add(topping);
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }
}

```

In this example, the `Pizza` class has a private constructor that takes a `Builder` object. The `Pizza.Builder` class is a static inner class that has the same fields as the `Pizza` class, as well as methods for adding toppings and building the final `Pizza` object.

To create a `Pizza` object, you first create a `Pizza.Builder` object with the required parameters (`crust` and `sauce`), then chain calls to the `addTopping` method to add toppings, and finally call the `build` method to create the final `Pizza` object.

Here's an example on how to instantiate `Pizza` using the builder pattern with Java:

```
Pizza margheritaPizza = new Pizza.Builder("thin crust", "tomato sauce")
                                .addTopping("mozzarella cheese")
                                .addTopping("fresh basil")
                                .build();

```

In this example, a `Pizza` object named `margheritaPizza` is created with a thin crust and tomato sauce, and is topped with mozzarella cheese and fresh basil. The `build` method is called to create the final `Pizza` object. This approach allows for more control over the creation process and makes it easier to create complex objects with a large number of parameters.