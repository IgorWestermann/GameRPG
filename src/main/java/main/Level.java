package main;

import javax.swing.*;
import java.awt.*;

public class Level {
    private Image background;


    public Level() {
        ImageIcon ref = new ImageIcon("/tiles/ground.png");
        background = ref.getImage();
    }
    public void paint(Graphics g) {
        Graphics2D graphics = (Graphics2D) g;
        graphics.drawImage(background,0,0,null);
        g.dispose();
    }
}
