package name.max_ferrara.temperature_main;

import name.max_ferrara.temperature.View;

import javax.swing.*;

public class TemperatureMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            View view = new View();
            view.createUI();
        });
    }
}
