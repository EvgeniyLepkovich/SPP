package by.bsuir.entity;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Segment {
    private static double x = 0;
    final double RAD = 10;
    private double length;
    private BufferedImage segment;
    private Color segmentColor;
    private Color pointColor;
    private Color backGroundColor;

    private Rectangle2D.Double r;
    private Ellipse2D.Double p;
    private double rotationAxis;

    private Point2D.Double center;
    private double shift;
    private int grad;

    public Segment(double length, double posPointRotating, int grad,
            Color segmentColor, Color pointColor, Color backGroundColor)
            throws Exception {

        if (length <= 0 || posPointRotating < 0 || length < posPointRotating)
            throw new Exception(
                    "Ошибка: неверно задан параметр в классе Segment");

        this.grad = grad;
        this.segmentColor = segmentColor;
        this.pointColor = pointColor;
        this.backGroundColor = backGroundColor;
        this.length = length;
        segment = new BufferedImage((int) length * 3, (int) length * 3,
                BufferedImage.TYPE_INT_ARGB);

        center = new Point2D.Double(length, 3 * length / 2);
        rotationAxis = center.x + posPointRotating - RAD / 2;
        r = new Rectangle2D.Double(center.x, center.y, length, RAD);
        p = new Ellipse2D.Double(rotationAxis, center.y, RAD, RAD);

        Graphics2D g2 = segment.createGraphics();

        g2.setBackground(backGroundColor);
        g2.clearRect(0, 0, (int) (3 * length), (int) (3 * length));

        g2.setColor(segmentColor);
        g2.fill(r);
        g2.setColor(pointColor);
        g2.fill(p);
    }

    public void setPos(double shiftX, double shiftY) {
        this.shift = shiftX;
        center.y = center.y + shiftY * Math.sin(Math.toRadians(grad * x));
        r = new Rectangle2D.Double(center.x, center.y, length, RAD);
        p = new Ellipse2D.Double(rotationAxis + shift, center.y, RAD, RAD);
    }

    public void rotate() {
        AffineTransform at = AffineTransform.getRotateInstance(
                Math.toRadians(grad * (++x)), rotationAxis + RAD / 2 + shift,
                center.y);
        Graphics2D g2 = segment.createGraphics();
        g2.setBackground(backGroundColor);
        g2.setColor(segmentColor);
        g2.clearRect(0, 0, (int) (3 * length), (int) (3 * length));
        g2.setTransform(at);
        g2.fill(r);
        g2.setColor(pointColor);
        g2.fill(p);
    }

    public void changeColor(){
        segmentColor = new Color(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255));
    }

    public BufferedImage getSegment() {
        return segment;
    }
}
