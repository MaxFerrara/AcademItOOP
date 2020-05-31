package name.max_ferrara.temperature_v2.model;

import java.util.Objects;

public class TemperatureConverter {
    private final Scale[] scales;

    public TemperatureConverter(Scale[] scales) {
        this.scales = scales;
    }

    public double convertTemperature(double temperature, Scale from, Scale to) {
        double convertResult = from.convertToCelsius(temperature);

        return to.convertFromCelsius(convertResult);
    }

    public Scale getScale(String temperature) {
        Scale scaleToFind = null;

        for (Scale scale : scales) {
            if (Objects.equals(temperature, scale.getName())) {
                scaleToFind = scale;
            }
        }

        return scaleToFind;
    }

    public Scale[] getScales() {
        return scales;
    }
}
