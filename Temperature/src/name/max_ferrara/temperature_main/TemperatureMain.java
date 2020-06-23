package name.max_ferrara.temperature_main;

import name.max_ferrara.temperature.controller.Controller;
import name.max_ferrara.temperature.model.*;
import name.max_ferrara.temperature.view.DesktopTemperatureView;
import name.max_ferrara.temperature.view.TemperatureView;

public class TemperatureMain {
    public static void main(String[] args) {
        Scale[] scales = {new CelsiusScale(), new FahrenheitScale(), new KelvinScale()};

        TemperatureConverter converter = new TemperatureConverter(scales);
        Controller controller = new Controller(converter);
        TemperatureView view = new DesktopTemperatureView(controller);
        controller.setView(view);
    }
}
