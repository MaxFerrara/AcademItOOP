package name.max_ferrara.temperature_v2.view;

import name.max_ferrara.temperature_v2.controller.Controller;
import name.max_ferrara.temperature_v2.model.Scale;

public interface TemperatureView {
    double getInputTemperature();

    Scale getInitialScale();

    Scale getEndScale();

    void setOutputTemperature(double temperature);

    void resetScaleFields();

    void setController(Controller controller);
}
