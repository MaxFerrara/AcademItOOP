package name.max_ferrara.temperature_v2.model;

public class TemperatureConverter {
    public double convertTemperature(double temperature, Temperature from, Temperature to) {
        double result = from.convertToCelsius(temperature);

        return to.convertFromCelsius(result);
    }
}
