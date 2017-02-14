package by.bsuir.entity;

import javax.swing.*;
import java.util.Random;

public class Animator {
    public void startAnimation(JPanel jPanel, final int width){
        int pick = Direction.values()[new Random().nextInt(Direction.values().length)].ordinal();
        if (pick == 0){
            startAnimation(jPanel, 0, width);
        } else {
            startAnimation(jPanel, width, 0);
        }
    }

    private void startAnimation(final JPanel jPanel, final int from, final int to){
        final Quote quote = new Quote();
        int f = from;
        int t = to;
        JLabel jLabel = new JLabel(quote.getRandomQuote());
        System.out.println(jLabel.getAlignmentX());
        jPanel.add(jLabel);
        jLabel.setLocation(f, 0);
        for (int i = 0; f > t ? t < f : t > f; i++){
            jLabel.setLocation(f > t ? t++ : t--, 0);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
