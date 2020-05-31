package name.max_ferrara.temperature_v2.view;

import name.max_ferrara.temperature_v2.controller.Controller;
import name.max_ferrara.temperature_v2.model.Scale;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Objects;


public class DesktopTemperatureView extends JFrame implements TemperatureView {
    private JComboBox<String> firstTemperaturesSpinner;
    private JComboBox<String> secondTemperaturesSpinner;
    private final JButton convertButton = new JButton("convert");
    private final JButton resetButton = new JButton("reset");
    private final JTextField temperatureInput = new JTextField(8);
    private final JTextField temperatureOutput = new JTextField(8);
    private String[] temperatureValues;

    private Controller controller;

    public DesktopTemperatureView(Controller controller) {
        this.controller = controller;

        temperatureValues = new String[controller.getScales().length];

        for (int i = 0; i < temperatureValues.length; ++i) {
            temperatureValues[i] = controller.getScales()[i].getName();
        }

        frameInit();
    }

    public void frameInit() {
        SwingUtilities.invokeLater(() -> {
            setTitle("Temperature converter powered by MaxFerrara");
            setLocation(800, 400);
            setSize(350, 220);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setResizable(false);
            setVisible(true);

            JPanel mainPanel = new JPanel();
            add(mainPanel);

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

            convertButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //double inputTemperature = getInputTemperature();

                    double outputTemperature = controller.convertTemperature();
                    setOutputTemperature(outputTemperature);
                }
            });

            resetButton.addActionListener(e -> resetScaleFields());
        });
    }

    @Override
    public double getInputTemperature() {
        return Double.parseDouble(temperatureInput.getText());
    }

    private Scale getScale(Object scale) {
        controller.getScales();
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
