package name.max_ferrara.temperature_v2.main;

import name.max_ferrara.temperature_v2.controller.Controller;
import name.max_ferrara.temperature_v2.model.*;
import name.max_ferrara.temperature_v2.view.DesktopTemperatureView;
import name.max_ferrara.temperature_v2.view.TemperatureView;

public class TemperatureMain {
    public static void main(String[] args) {
        Scale[] temperatures = {new CelsiusScale(), new FahrenheitScale(), new KelvinScale()};

        TemperatureConverter converter = new TemperatureConverter(temperatures);
        TemperatureView view = new DesktopTemperatureView();
        Controller controller = new Controller(view, converter);
        view.setController(controller);
    }
}
