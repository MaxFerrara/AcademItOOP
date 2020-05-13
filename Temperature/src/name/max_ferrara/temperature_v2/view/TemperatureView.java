package name.max_ferrara.temperature_v2.view;

import java.awt.event.ActionListener;

public interface TemperatureView {
    double getInputTemperature();

    String getFirstSpinnerValue();

    String getSecondSpinnerValue();

    void setOutputTemperature(String temperature);

    void addConvertActionListener(ActionListener listener);

    void addResetActionListener(ActionListener listener);

    void clearViewFields();
}
