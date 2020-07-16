package name.max_ferrara.mines_weeper.view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameField_v1 {
    private JPanel mainPanel;
    private JPanel fieldPanel;
    private JFrame mainFrame;

    private JButton newGameButton;
    private JButton settingsButton;
    private JButton recordsButton;
    private JButton pauseResumeButton;


    private Settings settings = new Settings();
    private GUIElement guiElement = new GUIElement();

    private JLabel testImage;
    private JLabel testImage1;

    public GameField_v1() {
        createFrame();
        //initPanel();
    }

    private void createFrame() {
        mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setTitle("GOAT MineSweeper");
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
        mainFrame.setLocationRelativeTo(null);

        mainPanel = new JPanel();
        mainFrame.add(mainPanel, BorderLayout.NORTH);
        GridBagLayout gridBagLayout = new GridBagLayout();
        mainPanel.setLayout(gridBagLayout);

        GridBagConstraints newGameButtonConstrains = new GridBagConstraints();
        newGameButtonConstrains.gridx = 0;
        newGameButtonConstrains.gridy = 0;
        newGameButtonConstrains.gridwidth = 1;
        newGameButton = buttonCreator("new game", 100, 30);
        mainPanel.add(newGameButton, newGameButtonConstrains);

        GridBagConstraints recordsButtonConstrains = new GridBagConstraints();
        recordsButtonConstrains.gridx = 1;
        recordsButtonConstrains.gridy = 0;
        recordsButtonConstrains.gridwidth = 1;
        recordsButton = buttonCreator("records", 100, 30);
        mainPanel.add(recordsButton, recordsButtonConstrains);

        GridBagConstraints settingsButtonConstrains = new GridBagConstraints();
        settingsButtonConstrains.gridx = 2;
        settingsButtonConstrains.gridy = 0;
        settingsButtonConstrains.gridwidth = 1;
        settingsButton = buttonCreator("settings", 100, 30);
        mainPanel.add(settingsButton, settingsButtonConstrains);

        GridBagConstraints pauseResumeButtonConstrains = new GridBagConstraints();
        pauseResumeButtonConstrains.gridx = 3;
        pauseResumeButtonConstrains.gridy = 0;
        pauseResumeButtonConstrains.gridwidth = 1;
        pauseResumeButton = buttonCreator("pause/resume", 100, 30);
        mainPanel.add(pauseResumeButton, pauseResumeButtonConstrains);

        fieldPanel = new JPanel();
        fieldPanel.setLayout(new GridLayout(settings.getFiledSideSize(), settings.getFiledSideSize()));
        fieldPanel.setBackground(Color.yellow);
        fieldPanel.setPreferredSize(new Dimension(getFieldSizeSide(), getFieldSizeSide()));
        mainFrame.add(fieldPanel, BorderLayout.CENTER);

        testImage = new JLabel(getImageIcon("bomb"));
        fieldPanel.add(testImage);

        testImage1 = new JLabel(getImageIcon("closed"));
        fieldPanel.add(testImage1);


        mainFrame.pack();
    }

    private JButton buttonCreator(String title, int width, int height) {
        JButton button = new JButton();
        button.setText(title);
        button.setSize(new Dimension(width, height));

        return button;
    }

    private int getFieldSizeSide() {
        return settings.getFiledSideSize() * guiElement.getIMAGE_SIZE();
    }

    private Image getImage(String name) {
        String fileName = "/" + name + ".png";
        ImageIcon icon = new ImageIcon(getClass().getResource(fileName));

        return icon.getImage();
    }

    private ImageIcon getImageIcon(String name) {
        String fileName = "/" + name + ".png";
        ImageIcon icon = new ImageIcon(getClass().getResource(fileName));

        return icon;
    }

    private void initOutsideField() {
        int arraySize = settings.getFiledSideSize() * settings.getFiledSideSize();

        ArrayList<JPanel> field = new ArrayList<>(arraySize);
    }
}
