package name.max_ferrara.temperature.model;

public class TemperatureConverter {
    private final Scale[] scales;

    public TemperatureConverter(Scale[] scales) {
        this.scales = scales;
    }

    public double convertTemperature(double temperature, Scale from, Scale to) {
        double convertResult = from.convertToCelsius(temperature);

        return to.convertFromCelsius(convertResult);
    }

    public Scale[] getScales() {
        return scales;
    }
}
