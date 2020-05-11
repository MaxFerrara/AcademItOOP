package name.max_ferrara.temperature_v2.model;

public class TemperatureConverter {
    CelsiusTemperature celsius = new CelsiusTemperature();
    FahrenheitTemperature fahrenheit = new FahrenheitTemperature();
    KelvinTemperature kelvin = new KelvinTemperature();
    private final String[] temperatureValues = {"celsius", "fahrenheit", "kalvin"};

    public TemperatureConverter(String temperature) {

    }

    public double convertTemperature() {
        double result = 0;

        return result;
    }
}
