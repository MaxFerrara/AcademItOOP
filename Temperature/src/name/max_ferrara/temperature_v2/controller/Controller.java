package name.max_ferrara.temperature_v2.controller;

import name.max_ferrara.temperature_v2.model.TemperatureConverter;
import name.max_ferrara.temperature_v2.view.TemperatureView;

public class Controller {
    private TemperatureView view;
    private TemperatureConverter converter;

    public Controller(TemperatureView view, TemperatureConverter converter) {
        this.view = view;
        this.converter = converter;

        initController();
    }

    public void initController() {
        this.view.addConvertActionListener(e -> {
            try {
                double convertResult;
                double inputTemperature = view.getInputTemperature();

                convertResult = converter.convertTemperature(inputTemperature, view.getInitialScale(), view.getEndScale());
                view.setOutputTemperature(convertResult);
            } catch (NumberFormatException | StringIndexOutOfBoundsException n) {
                view.showInputErrors();
            }
        });

        this.view.addResetActionListener(e -> view.resetScaleFields());
    }
}
