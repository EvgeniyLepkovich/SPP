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
    private int r;

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillOval(x, y, r, r);
    }
}
