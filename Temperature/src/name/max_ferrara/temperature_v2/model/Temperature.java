package name.max_ferrara.temperature_v2.model;

public interface Temperature {
    String getName();

    double convertToCelsius(double temperature);

    double convertFromCelsius(double temperature);
}
