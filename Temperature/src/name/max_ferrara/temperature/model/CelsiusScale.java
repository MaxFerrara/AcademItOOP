package name.max_ferrara.temperature.model;

public class CelsiusScale implements Scale {

    @Override
    public String getName() {
        return "celsius";
    }

    @Override
    public double convertToCelsius(double temperature) {
        return temperature;
    }

    @Override
    public double convertFromCelsius(double temperature) {
        return temperature;
    }
}
