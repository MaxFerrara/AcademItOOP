package name.max_ferrara.temperature_v2.model;

public class FahrenheitTemperature implements Temperature {
    @Override
    public double getCelsius(double temperature) {
        return (temperature - FAHRENHEIT_CONSTANT) / CELSIUS_FAHRENHEIT_COEFFICIENT;
    }

    @Override
    public double getFahrenheit(double temperature) {
        return temperature;
    }

    @Override
    public double getKalvin(double temperature) {
        return (temperature - FAHRENHEIT_CONSTANT) / CELSIUS_FAHRENHEIT_COEFFICIENT + KELVIN_CONSTANT;
    }
}
