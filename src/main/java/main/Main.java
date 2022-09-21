package main;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame screen =  new JFrame();
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setResizable(false);
        screen.setTitle("Main.Main.Game OO");

        Game game = new Game();
        screen.add(game);


        screen.pack();

        screen.setLocationRelativeTo(null);
        screen.setVisible(true);

        game.start();


    }

}
