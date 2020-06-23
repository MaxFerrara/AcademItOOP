package name.max_ferrara.temperature.model;

public class TemperatureConverter {
    private final Scale[] scales;

    public TemperatureConverter(Scale[] scales) {
        this.scales = scales;
    }

    public double convertTemperature(double temperature, Scale from, Scale to) {
        return to.convertFromCelsius(from.convertToCelsius(temperature));
    }

    public Scale[] getScales() {
        return scales;
    }
}
