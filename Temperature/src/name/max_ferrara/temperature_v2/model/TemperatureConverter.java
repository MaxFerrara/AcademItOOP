package name.max_ferrara.temperature_v2.model;

public class TemperatureConverter {
    public Temperature celsius = new CelsiusTemperature();
    public Temperature fahrenheit = new FahrenheitTemperature();
    public Temperature kelvin = new KelvinTemperature();

    public Object[] Scales = {celsius, fahrenheit, kelvin};

    public double convertTemperature(double temperature, Temperature from, Temperature to) {
        double result = from.convertToCelsius(temperature);

        return to.convertFromCelsius(result);
    }
}
