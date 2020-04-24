package name.max_ferrara.temperature;

public class Model {
    private static final double CELSIUS_FAHRENHEIT_COEFFICIENT = 1.8;
    private static final double KALVIN_CONSTANT = 273.15;
    private static final double FAHRENHEIT_CONSTANT = 32;

    public double getCelsiusFromFahrenheit(double temperature) {
        return (temperature - FAHRENHEIT_CONSTANT) * 5 / 9;
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
        return (temperature - FAHRENHEIT_CONSTANT) * 5 / 9 + KALVIN_CONSTANT;
    }
}
