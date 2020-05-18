package name.max_ferrara.temperature_main_v2;

import name.max_ferrara.temperature_v2.controller.Controller;
import name.max_ferrara.temperature_v2.model.*;
import name.max_ferrara.temperature_v2.view.DesktopTemperatureView;
import name.max_ferrara.temperature_v2.view.TemperatureView;

public class TemperatureMain {
    public static void main(String[] args) {
        Temperature[] temperatures = {new CelsiusTemperature(), new FahrenheitTemperature(), new KelvinTemperature()};
        TemperatureView view = new DesktopTemperatureView(temperatures);
        TemperatureConverter converter = new TemperatureConverter();
        Controller controller = new Controller(view, converter);
        controller.initController();
    }
}
