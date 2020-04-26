package name.max_ferrara.temperature1;

public class ModelNew {
    private final double CELSIUS_FAHRENHEIT_COEFFICIENT = 1.8;
    private final double KALVIN_CONSTANT = 273.15;
    private final double FAHRENHEIT_CONSTANT = 32;
    private final double REVERSED_CELSIUS_FAHRENHEIT_COEFFICIENT = 0.55;

    public double getCelsiusFromFahrenheit(double temperature) {
        return (temperature - FAHRENHEIT_CONSTANT) * REVERSED_CELSIUS_FAHRENHEIT_COEFFICIENT;
    }

    public double getCelsiusFromKelvin(double temperature) {
        return temperature - KALVIN_CONSTANT;
    }

    public double getFahrenheitFromCelsius(double temperature) {
        return temperature * CELSIUS_FAHRENHEIT_COEFFICIENT + FAHRENHEIT_CONSTANT;
    }

    public double getFahrenheitFromKelvin(double temperature) {
        return (temperature - KALVIN_CONSTANT) * CELSIUS_FAHRENHEIT_COEFFICIENT + FAHRENHEIT_CONSTANT;
    }

    public double getKalvinFromCelsius(double temperature) {
        return temperature + KALVIN_CONSTANT;
    }

    public double getKalvinFromFahrenheit(double temperature) {
        return (temperature - FAHRENHEIT_CONSTANT) * REVERSED_CELSIUS_FAHRENHEIT_COEFFICIENT + KALVIN_CONSTANT;
    }
}
