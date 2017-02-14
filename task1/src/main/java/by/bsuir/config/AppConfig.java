package by.bsuir.config;

import by.bsuir.entity.Animator;

import javax.swing.*;
import java.awt.*;

public class AppConfig {
    private static final int WIDTH = 300;
    private static final int HEIGHT = 300;

    public static void main(String[] args) throws Exception {
        JFrame jFrame = new JFrame("Движение строк");
        jFrame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.pack();

        Animator animator = new Animator();
        for (;;){
            JPanel jPanel = new JPanel();
            jFrame.add(jPanel);
            SwingUtilities.updateComponentTreeUI(jFrame);
            animator.startAnimation(jPanel, WIDTH);
            jFrame.remove(jPanel);
        }
    }
}
