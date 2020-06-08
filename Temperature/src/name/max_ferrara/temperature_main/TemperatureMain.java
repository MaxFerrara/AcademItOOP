package name.max_ferrara.temperature_main;

import name.max_ferrara.temperature.controller.Controller;
import name.max_ferrara.temperature.model.*;
import name.max_ferrara.temperature.view.DesktopTemperatureView;
import name.max_ferrara.temperature.view.TemperatureView;

public class TemperatureMain {
    public static void main(String[] args) {
        Scale[] temperatures = {new CelsiusScale(), new FahrenheitScale(), new KelvinScale()};

        TemperatureConverter converter = new TemperatureConverter(temperatures);
        TemperatureView view = new DesktopTemperatureView();
        Controller controller = new Controller(view, converter);
        
        view.setController(controller);
    }
}
