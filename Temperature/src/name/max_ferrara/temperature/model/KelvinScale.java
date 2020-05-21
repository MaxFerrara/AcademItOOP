package name.max_ferrara.temperature.model;

public class KelvinScale implements Scale {
    private final static double KALVIN_CONSTANT = 273.15;

    @Override
    public String getName() {
        return "kelvin";
    }

    @Override
    public double convertToCelsius(double temperature) {
        return temperature - KALVIN_CONSTANT;
    }

    @Override
    public double convertFromCelsius(double temperature) {
        return temperature + KALVIN_CONSTANT;
    }
}
