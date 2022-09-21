package main;

import entity.Player;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;


public class Game extends JPanel implements Runnable{
    // Screen settings
    public final int TILESIZE = 48;
    public final int WIDTH = 768; //768
    public final int HEIGHT = 576; // 576
    public final int ROW = 12;
    public final int COL = 16;
    final int ticks = 60;

    // Map settings
    public final int WORLD_COL = 50;
    public final int WORLD_ROW = 50;
    public final int WORLD_WIDTH = WORLD_COL * TILESIZE;
    public final int WORLD_HEIGHT = WORLD_ROW * TILESIZE;


    TileManager tileM = new TileManager(this);
    Input key = new Input();

    public Player player = new Player(this, key);




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
        Graphics2D graphics = (Graphics2D) g;
        tileM.paint(graphics);
        player.paint(graphics);


        g.dispose();

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
