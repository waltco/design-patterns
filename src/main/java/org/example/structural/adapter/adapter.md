# Adapter

**Adapter** is a structural design pattern that **allows objects with incompatible interfaces to collaborate.**

Here's an example of an adapter pattern for converting temperatures between Celsius and Fahrenheit using Java:

```java

// Adaptee
public class CelsiusTemperature {
    private double temperature;

    public CelsiusTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getTemperature() {
        return temperature;
    }
}

// Target
public interface FahrenheitTemperature {
    double getTemperature();
}

// Adapter
public class CelsiusToFahrenheitAdapter implements FahrenheitTemperature {
    private CelsiusTemperature celsiusTemperature;

    public CelsiusToFahrenheitAdapter(CelsiusTemperature celsiusTemperature) {
        this.celsiusTemperature = celsiusTemperature;
    }

    @Override
    public double getTemperature() {
        return (celsiusTemperature.getTemperature() * 1.8) + 32;
    }
}

// Client
public class TemperatureConverter {
    public static void main(String[] args) {
        CelsiusTemperature celsiusTemperature = new CelsiusTemperature(25);
        FahrenheitTemperature fahrenheitTemperature = new CelsiusToFahrenheitAdapter(celsiusTemperature);
        System.out.println("Celsius temperature: " + celsiusTemperature.getTemperature());
        System.out.println("Fahrenheit temperature: " + fahrenheitTemperature.getTemperature());
    }
}

```

In this example, **`CelsiusTemperature`** is the Adaptee class, which represents a temperature in Celsius. **`FahrenheitTemperature`** is the Target interface, which defines the interface for the client to convert temperatures in Fahrenheit. **`CelsiusToFahrenheitAdapter`** is the Adapter class that converts Celsius temperatures to Fahrenheit temperatures. Finally, **`TemperatureConverter`** is the client that uses the adapter to convert a temperature from Celsius to Fahrenheit.