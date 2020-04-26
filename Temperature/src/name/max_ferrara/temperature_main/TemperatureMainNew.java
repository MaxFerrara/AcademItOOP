package name.max_ferrara.temperature_main;

import name.max_ferrara.temperature1.ControllerNew;
import name.max_ferrara.temperature1.ModelNew;
import name.max_ferrara.temperature1.ViewNew;

import javax.swing.*;

public class TemperatureMainNew {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ModelNew model = new ModelNew();
            ViewNew view = new ViewNew();
            ControllerNew controller = new ControllerNew(model, view);
            controller.initController();
        });
    }
}
