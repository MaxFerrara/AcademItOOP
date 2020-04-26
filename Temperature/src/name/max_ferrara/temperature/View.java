package name.max_ferrara.temperature;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class View {
    Model model = new Model();
    JFrame errorFrame = new JFrame();
    JFrame mainFrame = new JFrame();

    public void createUIMessageError() {
        JPanel panel = new JPanel();
        errorFrame.add(panel);
        errorFrame.setTitle("Temperature converter powered by MaxFerrara");
        errorFrame.setLocation(550, 200);
        errorFrame.setSize(250, 80);
        errorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        errorFrame.setVisible(true);
        panel.add(new JLabel("equals scales were selected or letters entered"));
    }

    public void createUI() {
        JPanel panel = new JPanel();
        mainFrame.add(panel);
        mainFrame.setTitle("Temperature converter powered by MaxFerrara");
        mainFrame.setLocation(550, 200);
        mainFrame.setSize(350, 220);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);

        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);

        GridBagConstraints jLabelFromConstraints = new GridBagConstraints();
        jLabelFromConstraints.gridx = 0;
        jLabelFromConstraints.gridy = 0;
        jLabelFromConstraints.gridheight = 2;
        jLabelFromConstraints.gridwidth = 2;

        panel.add(new JLabel("from"), jLabelFromConstraints);

        GridBagConstraints firstSpinnerConstraints = new GridBagConstraints();
        firstSpinnerConstraints.gridx = 0;
        firstSpinnerConstraints.gridy = 25;
        firstSpinnerConstraints.gridheight = 2;
        firstSpinnerConstraints.gridwidth = 2;

        JComboBox<String> firstTemperaturesSpinner = new JComboBox<>();
        firstTemperaturesSpinner.addItem("celsius");
        firstTemperaturesSpinner.addItem("fahrenheit");
        firstTemperaturesSpinner.addItem("kalvin");

        panel.add(firstTemperaturesSpinner, firstSpinnerConstraints);

        GridBagConstraints jLabelToConstraints = new GridBagConstraints();
        jLabelToConstraints.gridx = 0;
        jLabelToConstraints.gridy = 50;
        jLabelToConstraints.gridheight = 2;
        jLabelToConstraints.gridwidth = 2;

        panel.add(new JLabel("to"), jLabelToConstraints);

        GridBagConstraints secondSpinnerConstraints = new GridBagConstraints();
        secondSpinnerConstraints.gridx = 0;
        secondSpinnerConstraints.gridy = 75;
        secondSpinnerConstraints.gridheight = 2;
        secondSpinnerConstraints.gridwidth = 2;

        JComboBox<String> secondTemperaturesSpinner = new JComboBox<>();
        secondTemperaturesSpinner.addItem("celsius");
        secondTemperaturesSpinner.addItem("fahrenheit");
        secondTemperaturesSpinner.addItem("kalvin");

        panel.add(secondTemperaturesSpinner, secondSpinnerConstraints);

        GridBagConstraints jLabelInputConstraints = new GridBagConstraints();
        jLabelInputConstraints.gridx = 85;
        jLabelInputConstraints.gridy = 0;
        jLabelInputConstraints.gridheight = 2;
        jLabelInputConstraints.gridwidth = 2;

        panel.add(new JLabel("input"), jLabelInputConstraints);

        GridBagConstraints inputFiledConstrains = new GridBagConstraints();
        inputFiledConstrains.gridx = 85;
        inputFiledConstrains.gridy = 25;
        inputFiledConstrains.gridheight = 2;
        inputFiledConstrains.gridwidth = 2;

        JTextField input = new JTextField(8);

        panel.add(input, inputFiledConstrains);

        GridBagConstraints jLabelOutputConstraints = new GridBagConstraints();
        jLabelOutputConstraints.gridx = 85;
        jLabelOutputConstraints.gridy = 50;
        jLabelOutputConstraints.gridheight = 2;
        jLabelOutputConstraints.gridwidth = 2;

        panel.add(new JLabel("output"), jLabelOutputConstraints);

        GridBagConstraints outputFieldConstraints = new GridBagConstraints();
        outputFieldConstraints.gridx = 85;
        outputFieldConstraints.gridy = 75;
        outputFieldConstraints.gridheight = 2;
        outputFieldConstraints.gridwidth = 2;

        JTextField output = new JTextField(8);
        //output.setEditable(false);
        panel.add(output, outputFieldConstraints);

        GridBagConstraints convertButtonConstraints = new GridBagConstraints();
        convertButtonConstraints.gridx = 42;
        convertButtonConstraints.gridy = 95;
        convertButtonConstraints.gridheight = 2;
        convertButtonConstraints.gridwidth = 2;

        JButton convert = new JButton("convert");

        panel.add(convert, convertButtonConstraints);

        GridBagConstraints resetButtonConstraints = new GridBagConstraints();
        resetButtonConstraints.gridx = 42;
        resetButtonConstraints.gridy = 115;
        resetButtonConstraints.gridheight = 2;
        resetButtonConstraints.gridwidth = 2;

        JButton reset = new JButton("reset");

        panel.add(reset, resetButtonConstraints);

        convert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Objects.equals(firstTemperaturesSpinner.getSelectedItem(), secondTemperaturesSpinner.getSelectedItem())) {
                    createUIMessageError();
                } else {
                    double convertResult = 0;
                    String stringTemperature = input.getText();
                    double digitTemperature = Double.parseDouble(stringTemperature);

                    if (Objects.equals(firstTemperaturesSpinner.getSelectedItem(), "celsius") && Objects.equals(secondTemperaturesSpinner.getSelectedItem(), "fahrenheit")) {
                        convertResult = model.getFahrenheitFromCelsius(digitTemperature);
                    }

                    if (Objects.equals(firstTemperaturesSpinner.getSelectedItem(), "celsius") && Objects.equals(secondTemperaturesSpinner.getSelectedItem(), "kalvin")) {
                        convertResult = model.getKalvinFromCelsius(digitTemperature);
                    }

                    if (Objects.equals(firstTemperaturesSpinner.getSelectedItem(), "fahrenheit") && Objects.equals(secondTemperaturesSpinner.getSelectedItem(), "celsius")) {
                        convertResult = model.getCelsiusFromFahrenheit(digitTemperature);
                    }

                    if (Objects.equals(firstTemperaturesSpinner.getSelectedItem(), "fahrenheit") && Objects.equals(secondTemperaturesSpinner.getSelectedItem(), "kalvin")) {
                        convertResult = model.getKalvinFromFahrenheit(digitTemperature);
                    }

                    if (Objects.equals(firstTemperaturesSpinner.getSelectedItem(), "kalvin") && Objects.equals(secondTemperaturesSpinner.getSelectedItem(), "celsius")) {
                        convertResult = model.getCelsiusFromKelvin(digitTemperature);
                    }

                    if (Objects.equals(firstTemperaturesSpinner.getSelectedItem(), "kalvin") && Objects.equals(secondTemperaturesSpinner.getSelectedItem(), "fahrenheit")) {
                        convertResult = model.getFahrenheitFromKelvin(digitTemperature);
                    }

                    output.setText(String.valueOf(convertResult));
                }
            }
        });

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText("");
                input.setText("");
            }
        });
    }
}
