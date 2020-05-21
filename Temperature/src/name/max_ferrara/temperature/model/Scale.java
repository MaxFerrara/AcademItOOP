package name.max_ferrara.temperature.model;

public interface Scale {
    String getName();

    double convertToCelsius(double temperature);

    double convertFromCelsius(double temperature);
}
