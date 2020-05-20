package name.max_ferrara.temperature_v2.view;

import name.max_ferrara.temperature_v2.model.Temperature;

import java.awt.event.ActionListener;

public interface TemperatureView {
    double getInputTemperature();

    Temperature getInitialScale();

    Temperature getEndScale();

    void setOutputTemperature(double temperature);

    void addResetActionListener(ActionListener listener);

    void addConvertActionListener(ActionListener listener);

    void resetScaleFields();

    void showInputErrors();
}
