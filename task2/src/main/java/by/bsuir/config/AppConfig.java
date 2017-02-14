package by.bsuir.config;

import by.bsuir.entity.Circle;

import javax.swing.*;
import java.awt.*;

public class AppConfig {
    private static final int WIDTH = 300;
    private static final int HEIGHT = 300;

    private static final int CIRCLE_X = 50;
    private static final int CIRCLE_Y = 50;
    private static final int CIRCLE_SPEED_X = 1;
    private static final int CIRCLE_SPEED_Y = 1;
    private static final int CIRCLE_R = 50;

    public static void main(String[] args) throws InterruptedException {
        JFrame jFrame = new JFrame("Движение окружности");
        Circle circle = new Circle(CIRCLE_X, CIRCLE_Y, CIRCLE_SPEED_X, CIRCLE_SPEED_Y, CIRCLE_R);
        jFrame.add(circle);
        jFrame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.pack();

        for (;;){
            circle.moveX();
            int x = circle.getX();
            int dx = circle.getDx();
            if ((dx > 0 && x + CIRCLE_R * 4 > WIDTH) || (dx < 0 && x < 0)) {
                circle.expand();
            }
            Thread.sleep(100);
        }
    }
}
