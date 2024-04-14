package pack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Slip17b extends JFrame {
    private JTextField textField;
    private JButton startButton;
    private volatile boolean isRunning;

    public Slip17b() {
        setTitle("Number Display");
        setSize(300, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        textField = new JTextField(10);
        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!isRunning) {
                    isRunning = true;
                    new Thread(new NumberDisplayTask()).start();
                    startButton.setEnabled(false);
                }
            }
        });

        add(textField);
        add(startButton);

        setVisible(true);
    }

    private class NumberDisplayTask implements Runnable {
        public void run() {
            try {
                for (int i = 1; i <= 100 && isRunning; i++) {
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            textField.setText(String.valueOf(i));
                        }
                    });
                    Thread.sleep(1000); // Sleep for 1 second
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                isRunning = false;
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        startButton.setEnabled(true);
                    }
                });
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Slip17b();
            }
        });
    }
}
