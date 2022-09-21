package tile;

import main.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.util.Objects;

public class TileManager {
    Game game;
    Tile[] tile;
    int[][] mapTileNum;


    public TileManager(Game game) {
        this.game = game;

        tile = new Tile[10];
        mapTileNum = new int[game.COL][game.ROW];
        loadTiles();
        loadMap();
    }

    public void loadMap() {

        InputStream is = getClass().getResourceAsStream("/maps/map01.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        try {
            for (int y = 0; y < game.ROW; y++) {
                String s = br.readLine();
                String[] nums = s.split(" ");
                for (int x = 0; x < game.COL; x++) {
                    mapTileNum[x][y] = Integer.parseInt(nums[x]);
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void loadTiles() {
        try {

            tile[0] = new Tile();
            tile[0].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/grass_1.png")));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/wall.png")));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/water.png")));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paint(Graphics2D g) {

        int xPos = 0;
        int yPos = 0;
        for (int j = 0; j < game.ROW; j++) {
            for (int i = 0; i < game.COL; i++) {
                int tileNum = mapTileNum[i][j];
                g.drawImage(tile[tileNum].image,xPos,yPos,game.TILESIZE,game.TILESIZE,null);
                xPos += game.TILESIZE;

            }
            xPos = 0;
            yPos += game.TILESIZE;
        }

    }
}
