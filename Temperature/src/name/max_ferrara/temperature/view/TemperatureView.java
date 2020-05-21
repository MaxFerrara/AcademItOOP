package name.max_ferrara.temperature.view;

import name.max_ferrara.temperature.model.Scale;

import java.awt.event.ActionListener;

public interface TemperatureView {
    double getInputTemperature();

    Scale getInitialScale();

    Scale getEndScale();

    void setOutputTemperature(double temperature);

    void addResetActionListener(ActionListener listener);

    void addConvertActionListener(ActionListener listener);

    void resetScaleFields();

    void showInputErrors();
}
