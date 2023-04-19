package org.example.structural.adapter;

public class CelsiusToFahrenheitAdapter implements FahrenheitTemperature{

    private CelsiusTemperature celsiusTemperature;

    public CelsiusToFahrenheitAdapter(CelsiusTemperature celsiusTemperature) {
        this.celsiusTemperature = celsiusTemperature;
    }

    @Override
    public double getTemperature() {
        return (celsiusTemperature.getTemperature() * 1.8) + 32;
    }
}
