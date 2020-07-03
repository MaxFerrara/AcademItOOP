package name.max_ferrara.temperature.controller;

import name.max_ferrara.temperature.model.Scale;
import name.max_ferrara.temperature.model.TemperatureConverter;
import name.max_ferrara.temperature.view.TemperatureView;

public class Controller {
    private TemperatureView view;
    private final TemperatureConverter converter;

    public Controller(TemperatureConverter converter) {
        this.converter = converter;
    }

    public Scale[] getScales() {
        return converter.getScales();
    }

    public double convertTemperature() {
        return converter.convertTemperature(view.getInputTemperature(), view.getInitialScale(), view.getEndScale());
    }

    public void setView(TemperatureView view) {
        this.view = view;
    }
}