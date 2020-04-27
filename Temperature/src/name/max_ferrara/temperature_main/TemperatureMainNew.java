package name.max_ferrara.temperature_main;

import name.max_ferrara.temperature.controller.Controller;
import name.max_ferrara.temperature.model.Model;
import name.max_ferrara.temperature.view.View;

import javax.swing.*;

public class TemperatureMainNew {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Model model = new Model();
            View view = new View();
            Controller controller = new Controller(model, view);
            controller.initController();
        });
    }
}
