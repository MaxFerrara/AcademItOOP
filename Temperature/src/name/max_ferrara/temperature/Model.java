package name.max_ferrara.temperature;

public class Model {
    private final double CELSIUS_FAHRENHEIT_COEFFICIENT = 1.8;
    private final double KALVIN_CONSTANT = 273.15;
    private final double FAHRENHEIT_CONSTANT = 32;

    public double getCelsiusFromFahrenheit(double temperature) {
        return CELSIUS_FAHRENHEIT_COEFFICIENT * (temperature - FAHRENHEIT_CONSTANT);
    }

    public double getCelsiusFromKelvin(double temperature) {
        return temperature - KALVIN_CONSTANT;
    }

    public double getFahrenheitFromCelsius(double temperature) {
        return temperature * CELSIUS_FAHRENHEIT_COEFFICIENT + FAHRENHEIT_CONSTANT;
    }

    //тут разберись и проверь завтра
    public double getFahrenheitFromKelvin(double temperature) {
        return getCelsiusFromFahrenheit(temperature) + KALVIN_CONSTANT;
    }

    public double getKalvinFromCelsius(double temperature) {
        return temperature + KALVIN_CONSTANT;
    }

    public double getKalvinFromFahrenheit(double temperature) {
        return (temperature - KALVIN_CONSTANT) * CELSIUS_FAHRENHEIT_COEFFICIENT + FAHRENHEIT_CONSTANT;
    }
}
