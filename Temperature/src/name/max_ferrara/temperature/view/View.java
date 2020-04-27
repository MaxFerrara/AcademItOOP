package name.max_ferrara.temperature.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame {
    private JComboBox<String> firstTemperaturesSpinner = new JComboBox<>();
    private JComboBox<String> secondTemperaturesSpinner = new JComboBox<>();
    private JButton convertButton = new JButton("convert");
    private JButton resetButton = new JButton("reset");
    private JTextField temperatureInput = new JTextField(8);
    private JTextField temperatureOutput = new JTextField(8);

    public View() {
        this.setTitle("Temperature converter powered by MaxFerrara");
        this.setLocation(800, 400);
        this.setSize(350, 220);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        JPanel mainPanel = new JPanel();
        this.add(mainPanel);

        GridBagLayout layout = new GridBagLayout();
        mainPanel.setLayout(layout);

        GridBagConstraints jLabelFromConstraints = new GridBagConstraints();
        jLabelFromConstraints.gridx = 0;
        jLabelFromConstraints.gridy = 0;
        jLabelFromConstraints.gridheight = 2;
        jLabelFromConstraints.gridwidth = 2;
        mainPanel.add(new JLabel("from"), jLabelFromConstraints);

        GridBagConstraints firstSpinnerConstraints = new GridBagConstraints();
        firstSpinnerConstraints.gridx = 0;
        firstSpinnerConstraints.gridy = 25;
        firstSpinnerConstraints.gridheight = 2;
        firstSpinnerConstraints.gridwidth = 2;
        firstTemperaturesSpinner.addItem("celsius");
        firstTemperaturesSpinner.addItem("fahrenheit");
        firstTemperaturesSpinner.addItem("kalvin");
        mainPanel.add(firstTemperaturesSpinner, firstSpinnerConstraints);

        GridBagConstraints jLabelToConstraints = new GridBagConstraints();
        jLabelToConstraints.gridx = 0;
        jLabelToConstraints.gridy = 50;
        jLabelToConstraints.gridheight = 2;
        jLabelToConstraints.gridwidth = 2;
        mainPanel.add(new JLabel("to"), jLabelToConstraints);

        GridBagConstraints secondSpinnerConstraints = new GridBagConstraints();
        secondSpinnerConstraints.gridx = 0;
        secondSpinnerConstraints.gridy = 75;
        secondSpinnerConstraints.gridheight = 2;
        secondSpinnerConstraints.gridwidth = 2;
        secondTemperaturesSpinner.addItem("celsius");
        secondTemperaturesSpinner.addItem("fahrenheit");
        secondTemperaturesSpinner.addItem("kalvin");
        mainPanel.add(secondTemperaturesSpinner, secondSpinnerConstraints);

        GridBagConstraints jLabelInputConstraints = new GridBagConstraints();
        jLabelInputConstraints.gridx = 85;
        jLabelInputConstraints.gridy = 0;
        jLabelInputConstraints.gridheight = 2;
        jLabelInputConstraints.gridwidth = 2;
        mainPanel.add(new JLabel("input"), jLabelInputConstraints);

        GridBagConstraints inputFiledConstrains = new GridBagConstraints();
        inputFiledConstrains.gridx = 85;
        inputFiledConstrains.gridy = 25;
        inputFiledConstrains.gridheight = 2;
        inputFiledConstrains.gridwidth = 2;
        mainPanel.add(temperatureInput, inputFiledConstrains);

        GridBagConstraints jLabelOutputConstraints = new GridBagConstraints();
        jLabelOutputConstraints.gridx = 85;
        jLabelOutputConstraints.gridy = 50;
        jLabelOutputConstraints.gridheight = 2;
        jLabelOutputConstraints.gridwidth = 2;
        mainPanel.add(new JLabel("output"), jLabelOutputConstraints);

        GridBagConstraints outputFieldConstraints = new GridBagConstraints();
        outputFieldConstraints.gridx = 85;
        outputFieldConstraints.gridy = 75;
        outputFieldConstraints.gridheight = 2;
        outputFieldConstraints.gridwidth = 2;
        temperatureOutput.setEditable(false);
        mainPanel.add(temperatureOutput, outputFieldConstraints);

        GridBagConstraints convertButtonConstraints = new GridBagConstraints();
        convertButtonConstraints.gridx = 42;
        convertButtonConstraints.gridy = 95;
        convertButtonConstraints.gridheight = 2;
        convertButtonConstraints.gridwidth = 2;
        mainPanel.add(convertButton, convertButtonConstraints);

        GridBagConstraints resetButtonConstraints = new GridBagConstraints();
        resetButtonConstraints.gridx = 42;
        resetButtonConstraints.gridy = 115;
        resetButtonConstraints.gridheight = 2;
        resetButtonConstraints.gridwidth = 2;
        mainPanel.add(resetButton, resetButtonConstraints);
    }

    public double getInputTemperature() {
        return Double.parseDouble(temperatureInput.getText());
    }

    public String getFirstSpinnerValue() {
        return (String) firstTemperaturesSpinner.getSelectedItem();
    }

    public String getSecondSpinnerValue() {
        return (String) secondTemperaturesSpinner.getSelectedItem();
    }

    public void setOutputTemperature(String temperature) {
        temperatureOutput.setText(temperature);
    }

    public void addConvertButtonListener(ActionListener listener) {
        convertButton.addActionListener(listener);
    }

    public void addResetButtonListener(ActionListener listener) {
        resetButton.addActionListener(listener);
    }

    public void clearViewFields() {
        temperatureOutput.setText("");
        temperatureInput.setText("");
    }
}
