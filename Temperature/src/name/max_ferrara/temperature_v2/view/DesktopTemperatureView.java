package name.max_ferrara.temperature_v2.view;

import name.max_ferrara.temperature_v2.model.Temperature;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Objects;

public class DesktopTemperatureView implements TemperatureView {
    private JComboBox<String> firstTemperaturesSpinner;
    private JComboBox<String> secondTemperaturesSpinner;
    private JButton convertButton = new JButton("convert");
    private JButton resetButton = new JButton("reset");
    private JTextField temperatureInput = new JTextField(8);
    private JTextField temperatureOutput = new JTextField(8);
    private Temperature[] temperatures;
    private String[] temperatureValues;

    public DesktopTemperatureView(Temperature[] temperatures) {
        SwingUtilities.invokeLater(() -> {
            this.temperatures = temperatures;

            temperatureValues = new String[temperatures.length];

            for (int i = 0; i < temperatureValues.length; ++i) {
                temperatureValues[i] = temperatures[i].getName();
            }

            JFrame frame = new JFrame();
            frame.setTitle("Temperature converter powered by MaxFerrara");
            frame.setLocation(800, 400);
            frame.setSize(350, 220);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            frame.setVisible(true);

            JPanel mainPanel = new JPanel();
            frame.add(mainPanel);

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
            mainPanel.add(firstTemperaturesSpinner = new JComboBox<>(temperatureValues), firstSpinnerConstraints);

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
            mainPanel.add(secondTemperaturesSpinner = new JComboBox<>(temperatureValues), secondSpinnerConstraints);

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
        });
    }

   /* @Override
    public double getInputTemperature() {
        String inputTemperature = temperatureInput.getText();
        char number = inputTemperature.charAt(0);

        if(temperatureInput.getText().isEmpty()) {
           JOptionPane.showMessageDialog(null, "input field is empty", "Warning", JOptionPane.WARNING_MESSAGE);
        }

        if(!Character.isDigit(number)) {
           JOptionPane.showMessageDialog(null, "input value is't number", "Warning", JOptionPane.WARNING_MESSAGE);
        }


        return Double.parseDouble(inputTemperature);
    }  */

    @Override
    public double getInputTemperature() {
        return Double.parseDouble(temperatureInput.getText());
    }

    private Temperature getScale(Object scale) {
        Temperature scaleToFind = null;

        for (Temperature temperature : temperatures) {
            if (Objects.equals(temperature.getName(), scale)) {
                scaleToFind = temperature;
            }
        }

        return scaleToFind;
    }

    @Override
    public Temperature getInitialScale() {
        return getScale(firstTemperaturesSpinner.getSelectedItem());
    }

    @Override
    public Temperature getEndScale() {
        return getScale(secondTemperaturesSpinner.getSelectedItem());
    }

    @Override
    public void setOutputTemperature(double temperature) {
        temperatureOutput.setText(new DecimalFormat("#0.00").format(temperature));
    }

    @Override
    public void addConvertActionListener(ActionListener listener) {
        convertButton.addActionListener(listener);
    }

    @Override
    public void addResetActionListener(ActionListener listener) {
        resetButton.addActionListener(listener);
    }

    @Override
    public void resetScaleFields() {
        temperatureOutput.setText("");
        temperatureInput.setText("");
    }

    @Override
    public void showInputErrors() {
        try {
            String inputTemperature = temperatureInput.getText();
            char number = inputTemperature.charAt(0);

            if (!Character.isDigit(number)) {
                JOptionPane.showMessageDialog(null, "input value is't number", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        } catch (StringIndexOutOfBoundsException n) {
            JOptionPane.showMessageDialog(null, "input field is empty", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }
}
