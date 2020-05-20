package name.max_ferrara.temperature_v2.model;

public class FahrenheitTemperature implements Temperature {
    private final static double CELSIUS_FAHRENHEIT_COEFFICIENT = 1.8;
    private final static double FAHRENHEIT_CONSTANT = 32;

    @Override
    public String getName() {
        return "fahrenheit";
    }

    @Override
    public double convertToCelsius(double temperature) {
        return (temperature - FAHRENHEIT_CONSTANT) / CELSIUS_FAHRENHEIT_COEFFICIENT;
    }

    @Override
    public double convertFromCelsius(double temperature) {
        return temperature * CELSIUS_FAHRENHEIT_COEFFICIENT + FAHRENHEIT_CONSTANT;
    }
}