package main;

import entity.Player;

import javax.swing.*;
import java.awt.*;


public class Game extends JPanel implements Runnable{
    public final int TILESIZE = 64;
    final int WIDTH = 1280;
    final int HEIGHT = 720;
    final int ticks = 60;

    Input key = new Input();

    Player player = new Player(this, key);

    Thread fps;

    public Game() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.addKeyListener(key);
        this.setFocusable(true);

    }

    public void start() {
        fps = new Thread(this);
        fps.start();
    }

    public void update() {
        player.update();
    }

    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D graphic = (Graphics2D) g;
        player.paint(graphic);
        graphic.dispose();
    }

    @Override
    public void run() {
        long initialTime = System.nanoTime();
        final double timeF = 1000000000 / ticks;
        double deltaF = 0;

        // game loop
        while(fps != null) {
            long currentTime = System.nanoTime();
            deltaF += (currentTime - initialTime) / timeF;
            initialTime = currentTime;
            if (deltaF >= 1) {
                update();
                deltaF--;
            }
            repaint();
        }
    }
}
