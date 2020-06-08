package name.max_ferrara.temperature.view;

import name.max_ferrara.temperature.controller.Controller;
import name.max_ferrara.temperature.model.Scale;

public interface TemperatureView {
    double getInputTemperature();

    Scale getInitialScale();

    Scale getEndScale();

    void setOutputTemperature(double temperature);

    void resetScaleFields();

    void setController(Controller controller);
}
