package by.bsuir.config;

import by.bsuir.entity.Circle;

import javax.swing.*;
import java.awt.*;

public class AppConfig {
    private static final int WIDTH = 300;
    private static final int HEIGHT = 300;

    private static final int CIRCLE_X = 50;
    private static final int CIRCLE_Y = 50;

    public static void main(String[] args) throws InterruptedException {
        JFrame jFrame = new JFrame("Движение окружности");
        jFrame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.pack();

        int circle_r = 50;
        int circle_speed_r = 1;
        for (;;){
            Circle circle = new Circle(CIRCLE_X, CIRCLE_Y, circle_r);
            jFrame.add(circle);
            SwingUtilities.updateComponentTreeUI(jFrame);
            Thread.sleep(100);
            if ((circle_r > 100 && circle_speed_r > 0) || (circle_r < 50 && circle_speed_r < 0)){
                circle_speed_r *= -1;
            }
            circle_r += circle_speed_r;
            jFrame.remove(circle);
        }
    }
}
