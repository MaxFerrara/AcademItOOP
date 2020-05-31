package name.max_ferrara.temperature_v2.view;

import name.max_ferrara.temperature_v2.model.Scale;

import java.awt.event.ActionListener;

public interface TemperatureView {
    double getInputTemperature();

    Scale getInitialScale();

    Scale getEndScale();

    void setOutputTemperature(double temperature);

    void resetScaleFields();
}
