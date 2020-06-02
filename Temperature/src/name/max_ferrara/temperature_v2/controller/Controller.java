package name.max_ferrara.temperature_v2.controller;

import name.max_ferrara.temperature_v2.model.Scale;
import name.max_ferrara.temperature_v2.model.TemperatureConverter;
import name.max_ferrara.temperature_v2.view.TemperatureView;

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