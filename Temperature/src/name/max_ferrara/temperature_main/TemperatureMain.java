package name.max_ferrara.temperature_main;

import javax.swing.*;
import java.awt.*;

public class TemperatureMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            JPanel panel = new JPanel();
            frame.add(panel);
            frame.setTitle("Temperature converter powered by MaxFerrara");
            frame.setLocation(550, 200);
            frame.setSize(350, 220);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

            GridBagLayout gbl = new GridBagLayout();
            panel.setLayout(gbl);

            GridBagConstraints constraints3 = new GridBagConstraints();
            constraints3.weightx = 0;
            constraints3.weighty = 0;
            constraints3.gridx = 0;
            constraints3.gridy = 0;
            constraints3.gridheight = 2;
            constraints3.gridwidth = 2;

            panel.add(new JLabel("from"), constraints3);

            GridBagConstraints constraints1 = new GridBagConstraints();
            constraints1.weightx = 0;
            constraints1.weighty = 0;
            constraints1.gridx = 0;
            constraints1.gridy = 25;
            constraints1.gridheight = 2;
            constraints1.gridwidth = 2;

            JComboBox<String> box1 = new JComboBox<>();
            box1.addItem("celsius");
            box1.addItem("fahrenheit");
            box1.addItem("kalvin");

            panel.add(box1, constraints1);

            GridBagConstraints constraints4 = new GridBagConstraints();
            constraints4.weightx = 0;
            constraints4.weighty = 0;
            constraints4.gridx = 0;
            constraints4.gridy = 50;
            constraints4.gridheight = 2;
            constraints4.gridwidth = 2;

            panel.add(new JLabel("to"), constraints4);

            GridBagConstraints constraints2 = new GridBagConstraints();
            constraints2.weightx = 0;
            constraints2.weighty = 0;
            constraints2.gridx = 0;
            constraints2.gridy = 75;
            constraints2.gridheight = 2;
            constraints2.gridwidth = 2;

            JComboBox<String> box2 = new JComboBox<>();
            box2.addItem("celsius");
            box2.addItem("fahrenheit");
            box2.addItem("kalvin");

            panel.add(box2, constraints2);

            GridBagConstraints constraints5 = new GridBagConstraints();
            constraints5.gridx = 85;
            constraints5.gridy = 0;
            constraints5.gridheight = 2;
            constraints5.gridwidth = 2;

            panel.add(new JLabel("input"), constraints5);

            GridBagConstraints constraints6 = new GridBagConstraints();
            constraints6.gridx = 85;
            constraints6.gridy = 25;
            constraints6.gridheight = 2;
            constraints6.gridwidth = 2;

            JTextField input = new JTextField(8);

            panel.add(input, constraints6);

            GridBagConstraints constraints7 = new GridBagConstraints();
            constraints7.gridx = 85;
            constraints7.gridy = 50;
            constraints7.gridheight = 2;
            constraints7.gridwidth = 2;

            panel.add(new JLabel("output"), constraints7);

            GridBagConstraints constraints8 = new GridBagConstraints();
            constraints8.gridx = 85;
            constraints8.gridy = 75;
            constraints8.gridheight = 2;
            constraints8.gridwidth = 2;

            JTextField output = new JTextField(8);
            panel.add(output, constraints8);

            GridBagConstraints constraints9 = new GridBagConstraints();
            constraints9.gridx = 42;
            constraints9.gridy = 95;
            constraints9.gridheight = 2;
            constraints9.gridwidth = 2;

            JButton convert = new JButton("convert");

            panel.add(convert, constraints9);

            GridBagConstraints constraints10 = new GridBagConstraints();
            constraints10.gridx = 42;
            constraints10.gridy = 115;
            constraints10.gridheight = 2;
            constraints10.gridwidth = 2;

            JButton reset = new JButton("reset");

            panel.add(reset, constraints10);
        });
    }
}
