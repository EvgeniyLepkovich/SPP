package by.bsuir.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.*;
import java.awt.*;

@AllArgsConstructor
@NoArgsConstructor
public @Data class Circle extends JPanel {
    private int x;
    private int y;
    private int dx;
    private int dy;
    private int r;

    public void expand(){
        dx *= -1;
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillOval(x, y, r, r);
    }

    public void moveX(){
        x += dx;
        this.setLocation(x, y);
    }

    public void moveY(){
        y += dy;
        this.setLocation(x, y);
    }

    public void moveXY(){
        x += dx;
        y += dy;
        this.setLocation(x, y);
    }
}
