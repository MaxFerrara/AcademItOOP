package view;

import javax.swing.*;
import java.awt.*;

public class mainFrame {
    private JButton settingsButton;
    private JButton recordsButton;
    private JButton startButton;
    private JButton exitButton;

    private JButton changeTimeButton;
    private JTextField bombsQuantityInput;
    private JTextField sideFieldInput;
    private JButton goBackButton;

    private JComboBox<String> recordsSpinner;
    private JLabel recordsInfoLabel;
    private final String[] recordsString = {"1: 150", "2: 200", "3: 250"};

    public mainFrame() {
        //createMainFrame();
        //createSettingsFrame();
        createRecordsFrame();
    }

    private void createMainFrame() {
        SwingUtilities.invokeLater(() -> {
            JFrame mainFrame = new JFrame();
            mainFrame.setTitle("MinusWeeper powered by MaxFerrara");
            mainFrame.setSize(250, 400);
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setResizable(false);
            mainFrame.setVisible(true);
            mainFrame.setLocationRelativeTo(null);

            JPanel mainPanel = new JPanel();
            mainFrame.add(mainPanel);

            GridBagLayout mainLayout = new GridBagLayout();
            mainPanel.setLayout(mainLayout);

            GridBagConstraints settingsButtonConstraints = new GridBagConstraints();
            settingsButtonConstraints.gridx = 0;
            settingsButtonConstraints.gridy = 0;
            settingsButtonConstraints.gridheight = 2;
            settingsButtonConstraints.gridwidth = 2;
            settingsButton = new JButton("settings");
            settingsButton.setPreferredSize(new Dimension(80, 40));
            mainPanel.add(settingsButton, settingsButtonConstraints);

            GridBagConstraints recordsButtonConstraints = new GridBagConstraints();
            recordsButtonConstraints.gridx = 0;
            recordsButtonConstraints.gridy = 200;
            recordsButtonConstraints.gridheight = 2;
            recordsButtonConstraints.gridwidth = 2;
            recordsButton = new JButton("records");
            recordsButton.setPreferredSize(new Dimension(80, 40));
            mainPanel.add(recordsButton, recordsButtonConstraints);

            GridBagConstraints startButtonConstraints = new GridBagConstraints();
            startButtonConstraints.gridx = 0;
            startButtonConstraints.gridy = 400;
            startButtonConstraints.gridheight = 2;
            startButtonConstraints.gridwidth = 2;
            startButton = new JButton("start");
            startButton.setPreferredSize(new Dimension(80, 40));
            mainPanel.add(startButton, startButtonConstraints);

            GridBagConstraints exitButtonConstraints = new GridBagConstraints();
            exitButtonConstraints.gridx = 200;
            exitButtonConstraints.gridy = 400;
            exitButtonConstraints.gridheight = 2;
            exitButtonConstraints.gridwidth = 2;
            exitButton = new JButton("exit");
            exitButton.setPreferredSize(new Dimension(80, 40));
            mainPanel.add(exitButton, exitButtonConstraints);
        });
    }

    public void createSettingsFrame() {
        SwingUtilities.invokeLater(() -> {
            JFrame settingsFrame = new JFrame();
            settingsFrame.setTitle("Settings");
            settingsFrame.setSize(250, 250);
            settingsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            settingsFrame.setResizable(false);
            settingsFrame.setVisible(true);
            settingsFrame.setLocationRelativeTo(null);

            JPanel settingsPanel = new JPanel();
            settingsFrame.add(settingsPanel);

            GridBagLayout settingsLayout = new GridBagLayout();
            settingsPanel.setLayout(settingsLayout);

            GridBagConstraints goBackButtonConstrains = new GridBagConstraints();
            goBackButtonConstrains.gridx = 0;
            goBackButtonConstrains.gridy = 0;
            goBackButtonConstrains.gridwidth = 2;
            goBackButton = new JButton("back");
            goBackButton.setPreferredSize(new Dimension(70, 20));
            settingsPanel.add(goBackButton, goBackButtonConstrains);

            GridBagConstraints jLabelFieldSideConstrains = new GridBagConstraints();
            jLabelFieldSideConstrains.gridx = 1;
            jLabelFieldSideConstrains.gridy = 1;
            jLabelFieldSideConstrains.gridwidth = 2;
            settingsPanel.add(new JLabel("enter side filed"), jLabelFieldSideConstrains);

            GridBagConstraints fieldSideInputConstrains = new GridBagConstraints();
            fieldSideInputConstrains.gridx = 1;
            fieldSideInputConstrains.gridy = 2;
            fieldSideInputConstrains.gridwidth = 2;
            sideFieldInput = new JTextFiledHint("default 9");
            sideFieldInput.setColumns(8);
            settingsPanel.add(sideFieldInput, fieldSideInputConstrains);

            GridBagConstraints jLabelBombsQuantityConstrains = new GridBagConstraints();
            jLabelBombsQuantityConstrains.gridx = 1;
            jLabelBombsQuantityConstrains.gridy = 3;
            jLabelBombsQuantityConstrains.gridwidth = 2;
            settingsPanel.add(new JLabel("enter bombs quantity"), jLabelBombsQuantityConstrains);

            GridBagConstraints bombsQuantityInputConstrains = new GridBagConstraints();
            bombsQuantityInputConstrains.gridx = 1;
            bombsQuantityInputConstrains.gridy = 4;
            bombsQuantityInputConstrains.gridwidth = 2;
            bombsQuantityInput = new JTextFiledHint("default 10");
            bombsQuantityInput.setColumns(8);
            settingsPanel.add(bombsQuantityInput, bombsQuantityInputConstrains);

            GridBagConstraints changeTimeButtonConstraints = new GridBagConstraints();
            changeTimeButtonConstraints.gridx = 1;
            changeTimeButtonConstraints.gridy = 5;
            changeTimeButtonConstraints.gridwidth = 2;
            changeTimeButton = new JButton("save changes");
            changeTimeButton.setPreferredSize(new Dimension(120, 30));
            settingsPanel.add(changeTimeButton, changeTimeButtonConstraints);
        });
    }

    public void createRecordsFrame() {
        SwingUtilities.invokeLater(() -> {
            JFrame recordsFrame = new JFrame();
            recordsFrame.setTitle("Records Table");
            recordsFrame.setSize(150, 250);
            recordsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            recordsFrame.setResizable(false);
            recordsFrame.setVisible(true);
            recordsFrame.setLocationRelativeTo(null);

            JPanel recordsPanel = new JPanel();
            recordsFrame.add(recordsPanel);

            GridBagLayout recordsLayout = new GridBagLayout();
            recordsPanel.setLayout(recordsLayout);

            GridBagConstraints jLabelTopThreeConstrains = new GridBagConstraints();
            jLabelTopThreeConstrains.gridx = 0;
            jLabelTopThreeConstrains.gridy = 0;
            jLabelTopThreeConstrains.gridwidth = 3;
            recordsInfoLabel = new JLabel("top 3:");
            recordsInfoLabel.setFont(new Font("Serif", Font.BOLD, 24));
            recordsPanel.add(recordsInfoLabel, jLabelTopThreeConstrains);

            GridBagConstraints recordsSpinnerConstrains = new GridBagConstraints();
            recordsSpinnerConstrains.gridx = 0;
            recordsSpinnerConstrains.gridy = 1;
            recordsSpinnerConstrains.gridwidth = 3;
            recordsSpinner = new JComboBox<>(recordsString);
            recordsSpinner.setFont(new Font("Serif", Font.BOLD, 24));
            recordsPanel.add(recordsSpinner, recordsSpinnerConstrains);

            GridBagConstraints goBackButtonConstrains = new GridBagConstraints();
            goBackButtonConstrains.gridx = 0;
            goBackButtonConstrains.gridy = 2;
            goBackButtonConstrains.gridwidth = 3;
            goBackButton = new JButton("back");
            goBackButton.setPreferredSize(new Dimension(90, 30));
            goBackButton.setFont(new Font("Serif", Font.BOLD, 20));
            recordsPanel.add(goBackButton, goBackButtonConstrains);
        });
    }
}
