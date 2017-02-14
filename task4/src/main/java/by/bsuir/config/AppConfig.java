package by.bsuir.config;

import by.bsuir.entity.Segment;
import java.applet.Applet;
import java.awt.*;
import java.awt.image.BufferedImage;

public class AppConfig extends Applet implements Runnable {
    private static final long serialVersionUID = 1L;
    private int w, h;
    private BufferedImage bi;
    private Graphics2D big;
    private boolean stop = false;
    private Thread timer = null;

    private Color fonColor = Color.WHITE;
    private Color segmentColor = Color.LIGHT_GRAY;
    private Color pointColor = Color.GREEN;
    private Segment segment;

    // начальное расположение рисунка
    private double lengthSegment;

    // направление смещения оси вращения
    private double movePoint = -1;
    private double shift = 0;
    private double speedPoint = 1;

    // скорость изменения положения в пространстве
    private int speedRepaint = 30;

    // угол на который происходит изменения положения отрезка
    private int grad = 15;

    public void init() {
        try {
            // Создаем объекты и устанавливаем начальные значения.
            Dimension dim = getSize();
            w = dim.width;
            h = dim.height;

            // Создаем Segment, задавая длину
            lengthSegment = (double) Math.min(w, h) / 3;
            segment = new Segment(lengthSegment, lengthSegment / 2, grad,
                    segmentColor, pointColor, fonColor);

            bi = (BufferedImage) createImage(w, h);
            big = bi.createGraphics();
            big.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            // Создаем поток, который будет периодически вызывать метод update.
            timer = new Thread(this);
            timer.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void update(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        drawSegment();
        g2.drawImage(bi, 0, 0, this);
    }

    private void drawSegment() {
        shift += movePoint * speedPoint;
        if (shift < -lengthSegment / 2) {
            movePoint *= -1;
            shift = -lengthSegment / 2;
            segment.changeColor();
        } else if (shift > lengthSegment / 2) {
            movePoint *= -1;
            shift = lengthSegment / 2;
            segment.changeColor();
        }
        segment.setPos(shift, speedPoint);
        segment.rotate();
        big.drawImage(segment.getSegment(), null, 0, 0);
    }

    public void run() {
        while (!stop) {
            try {
                repaint();
                Thread.currentThread();
                Thread.sleep(speedRepaint);
            } catch (Exception err) {
            }
        }
    }

    public void stop() {
        super.stop();
        stop = true;
    }

    public void start() {
        super.start();
        stop = false;
        if (timer == null) {
            timer = new Thread(this);
            timer.start();
        }

    }

    public void destroy() {
        super.destroy();
        stop = true;
        Thread.currentThread();
        Thread.yield();
    }
}
