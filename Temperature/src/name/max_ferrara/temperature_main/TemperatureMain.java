package name.max_ferrara.temperature_main;

import javax.swing.*;

public class TemperatureMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.setTitle("Temperature converter powered by MaxFerrara");
                frame.setLocation(500,500);
                frame.setSize(300,200);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);

                JButton button1 = new JButton("lol");
                button1.setSize(50,80);
                frame.add(button1);
            }
        });
    }
}
