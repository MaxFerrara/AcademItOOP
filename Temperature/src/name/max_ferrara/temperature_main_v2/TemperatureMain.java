package name.max_ferrara.temperature_main_v2;

import name.max_ferrara.temperature_v2.view.DesktopTemperatureView;
import name.max_ferrara.temperature_v2.view.TemperatureView;

public class TemperatureMain {
    public static void main(String[] args) {
        TemperatureView view = new DesktopTemperatureView();
        view.initView();
    }
}
