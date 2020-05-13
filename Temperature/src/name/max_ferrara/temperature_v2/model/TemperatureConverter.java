package name.max_ferrara.temperature_v2.model;

public class TemperatureConverter {
    Temperature celsius = new CelsiusTemperature();
    Temperature fahrenheit = new FahrenheitTemperature();
    Temperature kelvin = new KelvinTemperature();
    private String[] temperatureValues = {"celsius", "fahrenheit", "kalvin"};

    public double convertTemperature(String firstTemperature, String secondTemperature) {
        /*switch (firstTemperature) {
            case temperatureValues[0]:
                switch (secondTemperature) {
                    case temperatureValues[0]:
                        return celsius.getCelsius(0);
                    case temperatureValues[1]:
                        return celsius.getFahrenheit(0);
                    case temperatureValues[2]:
                        return celsius.getKalvin(0);
                }

                case

        }*/

        return 0;
    }
}
