package name.max_ferrara.temperature_v2.model;

public class KelvinTemperature implements Temperature {
    @Override
    public double getCelsius(double temperature) {
        return temperature - KELVIN_CONSTANT;
    }

    @Override
    public double getFahrenheit(double temperature) {
        return (temperature - KELVIN_CONSTANT) * CELSIUS_FAHRENHEIT_COEFFICIENT + FAHRENHEIT_CONSTANT;
    }

    @Override
    public double getKalvin(double temperature) {
        return temperature;
    }
}
