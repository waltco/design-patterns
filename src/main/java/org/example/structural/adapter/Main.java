package org.example.structural.adapter;

public class Main {
    public static void main(String[] args) {
        CelsiusTemperature celsiusTemperature = new CelsiusTemperature(25);
        FahrenheitTemperature fahrenheitTemperature = new CelsiusToFahrenheitAdapter(celsiusTemperature);
        System.out.println("Celsius temperature: " + celsiusTemperature.getTemperature());
        System.out.println("Fahrenheit temperature: " + fahrenheitTemperature.getTemperature());
    }
}
