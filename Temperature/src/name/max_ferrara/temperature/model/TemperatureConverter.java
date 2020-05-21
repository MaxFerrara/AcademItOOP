package name.max_ferrara.temperature.model;

public class TemperatureConverter {
    public double convertTemperature(double temperature, Scale from, Scale to) {
        double result = from.convertToCelsius(temperature);

        return to.convertFromCelsius(result);
    }
}
