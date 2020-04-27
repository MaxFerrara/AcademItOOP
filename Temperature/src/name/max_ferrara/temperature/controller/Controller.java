package name.max_ferrara.temperature.controller;

import name.max_ferrara.temperature.model.Model;
import name.max_ferrara.temperature.view.View;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.Objects;

public class Controller {
    private Model model;
    private View view;
    private final String[] temperatureValues = {"celsius", "fahrenheit", "kalvin"};

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void initController() {
        this.view.addConvertButtonListener(e -> {
            try {
                double convertResult;
                double inputTemperature = view.getInputTemperature();

                if (Objects.equals(view.getFirstSpinnerValue(), temperatureValues[0]) && Objects.equals(view.getSecondSpinnerValue(), temperatureValues[1])) {
                    convertResult = model.getFahrenheitFromCelsius(inputTemperature);
                } else if (Objects.equals(view.getFirstSpinnerValue(), temperatureValues[0]) && Objects.equals(view.getSecondSpinnerValue(), temperatureValues[2])) {
                    convertResult = model.getKalvinFromCelsius(inputTemperature);
                } else if (Objects.equals(view.getFirstSpinnerValue(), temperatureValues[1]) && Objects.equals(view.getSecondSpinnerValue(), temperatureValues[0])) {
                    convertResult = model.getCelsiusFromFahrenheit(inputTemperature);
                } else if (Objects.equals(view.getFirstSpinnerValue(), temperatureValues[1]) && Objects.equals(view.getSecondSpinnerValue(), temperatureValues[2])) {
                    convertResult = model.getKalvinFromFahrenheit(inputTemperature);
                } else if (Objects.equals(view.getFirstSpinnerValue(), temperatureValues[2]) && Objects.equals(view.getSecondSpinnerValue(), temperatureValues[0])) {
                    convertResult = model.getCelsiusFromKelvin(inputTemperature);
                } else if (Objects.equals(view.getFirstSpinnerValue(), temperatureValues[2]) && Objects.equals(view.getSecondSpinnerValue(), temperatureValues[1])) {
                    convertResult = model.getFahrenheitFromKelvin(inputTemperature);
                } else {
                    convertResult = view.getInputTemperature();
                }

                view.setOutputTemperature(new DecimalFormat("#0.00").format(convertResult));
            } catch (NumberFormatException n) {
                JOptionPane.showMessageDialog(null, "input value is't number", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        });

        this.view.addResetButtonListener(e -> view.clearViewFields());
    }
}
