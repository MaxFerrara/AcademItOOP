package name.max_ferrara.temperature_main;

import name.max_ferrara.temperature.controller.Controller;
import name.max_ferrara.temperature.model.*;
import name.max_ferrara.temperature.view.DesktopTemperatureView;
import name.max_ferrara.temperature.view.TemperatureView;

public class TemperatureMain {
    public static void main(String[] args) {
        Scale[] scales = {new CelsiusScale(), new FahrenheitScale(), new KelvinScale()};
        TemperatureView view = new DesktopTemperatureView(scales);
        TemperatureConverter converter = new TemperatureConverter();
        Controller controller = new Controller(view, converter);
        controller.initController();
    }
}
