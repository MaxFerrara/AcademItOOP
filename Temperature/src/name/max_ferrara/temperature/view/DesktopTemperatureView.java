package name.max_ferrara.temperature.view;

import name.max_ferrara.temperature.controller.Controller;
import name.max_ferrara.temperature.model.Scale;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.Objects;

public class DesktopTemperatureView implements TemperatureView {
    private JComboBox<String> firstTemperaturesSpinner;
    private JComboBox<String> secondTemperaturesSpinner;
    private JButton convertButton;
    private JButton resetButton;
    private JTextField temperatureInput;
    private JTextField temperatureOutput;
    private String[] temperatureValues;

    private final Controller controller;

    public DesktopTemperatureView(Controller controller) {
        this.controller = controller;
        createWindow();
    }

    private void createWindow() {
        SwingUtilities.invokeLater(() -> {
            Scale[] scales = controller.getScales();

            temperatureValues = new String[scales.length];

            for (int i = 0; i < temperatureValues.length; ++i) {
                temperatureValues[i] = scales[i].getName();
            }

            JFrame frame = new JFrame();
            frame.setTitle("Temperature converter powered by MaxFerrara");
            frame.setSize(350, 220);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);

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
            temperatureInput = new JTextField(8);
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
            temperatureOutput = new JTextField(8);
            temperatureOutput.setEditable(false);
            mainPanel.add(temperatureOutput, outputFieldConstraints);

            GridBagConstraints convertButtonConstraints = new GridBagConstraints();
            convertButtonConstraints.gridx = 42;
            convertButtonConstraints.gridy = 95;
            convertButtonConstraints.gridheight = 2;
            convertButtonConstraints.gridwidth = 2;
            convertButton = new JButton("convert");
            convertButton.setPreferredSize(new Dimension(80, 30));
            mainPanel.add(convertButton, convertButtonConstraints);

            GridBagConstraints resetButtonConstraints = new GridBagConstraints();
            resetButtonConstraints.gridx = 42;
            resetButtonConstraints.gridy = 115;
            resetButtonConstraints.gridheight = 2;
            resetButtonConstraints.gridwidth = 2;
            resetButton = new JButton("reset");
            resetButton.setPreferredSize(new Dimension(80, 30));
            mainPanel.add(resetButton, resetButtonConstraints);

            convertButton.addActionListener(e -> {
                try {
                    double outputTemperature = controller.convertTemperature();
                    setOutputTemperature(outputTemperature);
                } catch (StringIndexOutOfBoundsException | NumberFormatException n) {
                    JOptionPane.showMessageDialog(null, "input field is empty or temperature's value is not digit", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            });

            resetButton.addActionListener(e -> resetScaleFields());
        });
    }

    @Override
    public double getInputTemperature() {
        return Double.parseDouble(temperatureInput.getText());
    }

    private Scale getScale(Object temperature) {
        Scale scaleToFind = null;

        for (Scale scale : controller.getScales()) {
            if (Objects.equals(temperature, scale.getName())) {
                scaleToFind = scale;
            }
        }

        return scaleToFind;
    }

    @Override
    public Scale getInitialScale() {
        return getScale(firstTemperaturesSpinner.getSelectedItem());
    }

    @Override
    public Scale getEndScale() {
        return getScale(secondTemperaturesSpinner.getSelectedItem());
    }

    @Override
    public void setOutputTemperature(double temperature) {
        temperatureOutput.setText(new DecimalFormat("#0.00").format(temperature));
    }

    @Override
    public void resetScaleFields() {
        temperatureOutput.setText("");
        temperatureInput.setText("");
    }
}
