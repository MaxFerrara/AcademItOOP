package name.max_ferrara.temperature_v2.model;

public interface Temperature {
    double CELSIUS_FAHRENHEIT_COEFFICIENT = 1.8;
    double KELVIN_CONSTANT = 273.15;
    double FAHRENHEIT_CONSTANT = 32;

    double getCelsius(double temperature);

    double getFahrenheit(double temperature);

    double getKalvin(double temperature);
}
