package name.max_ferrara.temperature1;

import java.text.DecimalFormat;
import java.util.Objects;

public class ControllerNew {
    private ModelNew model;
    private ViewNew view;
    private final String[] temperatureValues = {"celsius", "fahrenheit", "kalvin"};

    public ControllerNew(ModelNew model, ViewNew view) {
        this.model = model;
        this.view = view;
    }

    public void initController() {
        this.view.addConvertButtonListener(e -> {
            double convertResult = 0;
            double inputTemperature = view.getInputTemperature();

            if(Objects.equals(view.getFirstSpinnerValue(), view.getSecondSpinnerValue())) {
                convertResult = view.getInputTemperature();
            }

            if (Objects.equals(view.getFirstSpinnerValue(), temperatureValues[0]) && Objects.equals(view.getSecondSpinnerValue(), temperatureValues[1])) {
                convertResult = model.getFahrenheitFromCelsius(inputTemperature);
            }

            if (Objects.equals(view.getFirstSpinnerValue(), temperatureValues[0]) && Objects.equals(view.getSecondSpinnerValue(), temperatureValues[2])) {
                convertResult = model.getKalvinFromCelsius(inputTemperature);
            }

            if (Objects.equals(view.getFirstSpinnerValue(), temperatureValues[1]) && Objects.equals(view.getSecondSpinnerValue(), temperatureValues[0])) {
                convertResult = model.getCelsiusFromFahrenheit(inputTemperature);
            }

            if (Objects.equals(view.getFirstSpinnerValue(), temperatureValues[1]) && Objects.equals(view.getSecondSpinnerValue(), temperatureValues[2])) {
                convertResult = model.getKalvinFromFahrenheit(inputTemperature);
            }

            if (Objects.equals(view.getFirstSpinnerValue(), temperatureValues[2]) && Objects.equals(view.getSecondSpinnerValue(), temperatureValues[0])) {
                convertResult = model.getCelsiusFromKelvin(inputTemperature);
            }

            if (Objects.equals(view.getFirstSpinnerValue(), temperatureValues[2]) && Objects.equals(view.getSecondSpinnerValue(), temperatureValues[1])) {
                convertResult = model.getFahrenheitFromKelvin(inputTemperature);
            }

            String formattedResult = new DecimalFormat("#0.00").format(convertResult);

            view.setOutputTemperature(formattedResult);

        });

        this.view.addResetButtonListener(e -> view.clearViewFields());
    }
}
