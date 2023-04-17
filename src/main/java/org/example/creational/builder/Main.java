package org.example.creational.builder;

public class Main {
    public static void main(String[] args) {
        Pizza margheritaPizza = new Pizza.Builder("thin crust", "tomato sauce")
                .addTopping("mozzarella cheese")
                .addTopping("fresh basil")
                .build();
        System.out.println(margheritaPizza);
    }
}
