package name.max_ferrara.temperature.controller;

import name.max_ferrara.temperature.model.Scale;
import name.max_ferrara.temperature.model.TemperatureConverter;
import name.max_ferrara.temperature.view.TemperatureView;

public class Controller {
    private TemperatureView view;
    private TemperatureConverter converter;

    public Controller(TemperatureView view, TemperatureConverter converter) {
        this.view = view;
        this.converter = converter;
    }

    public Scale[] getScales() {
        return converter.getScales();
    }

    public double convertTemperature() {
        return converter.convertTemperature(view.getInputTemperature(), view.getInitialScale(), view.getEndScale());
    }
}