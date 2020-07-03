package view;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    private final int COLUMNS = 15;
    private final int ROWS = 1;
    private final int IMAGE_SIZE = 50;
    private JPanel panel;

    public View() {
        initPanel();
        initFrame();
    }

    private void initPanel() {
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(getImage("bomb"), 0, 0, this);
            }
        };

        panel.setPreferredSize(new Dimension(COLUMNS * IMAGE_SIZE, ROWS * IMAGE_SIZE));
        add(panel);
    }

    public void initFrame() {
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Sapper");
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private Image getImage(String name) {
        //String imageName = "C:\\Users\\MAKCOH\\IdeaProjects\\AcademItOOP\\Sapper\\res" + name.toLowerCase() + ".png";
        String fileName = "Sapper/" + name.toLowerCase() + ".png";
        ImageIcon icon = new ImageIcon(getClass().getResource(fileName));

        return icon.getImage();
    }
}
