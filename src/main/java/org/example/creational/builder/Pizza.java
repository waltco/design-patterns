package org.example.creational.builder;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public String toString() {
        return "Pizza{" +
                "crust='" + crust + '\'' +
                ", sauce='" + sauce + '\'' +
                ", toppings=" + toppings +
                '}';
    }
}
