package tile;

import main.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class TileManager {
    Game game;
    Tile[] tile;
    int[][] mapTileNum;


    public TileManager(Game game) {
        this.game = game;

        tile = new Tile[10];
        mapTileNum = new int[game.WORLD_COL][game.WORLD_ROW];
        loadTiles();
        loadMap();
    }

    public void loadMap() {

        InputStream is = getClass().getResourceAsStream("/maps/map01.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        try {
            for (int y = 0; y < game.WORLD_ROW; y++) {
                String s = br.readLine();
                String[] nums = s.split(" ");
                for (int x = 0; x < game.WORLD_COL; x++) {
                    mapTileNum[x][y] = Integer.parseInt(nums[x]);
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void loadTiles() {
        String[] sprite_list = {
                "/tiles/grass.png",
                "/tiles/wall.png",
                "/tiles/water.png",
                "/tiles/earth.png",
                "/tiles/tree.png",
                "/tiles/sand.png",
        };
        try {

            for (int i = 0; i < 6; i++) {
                tile[i] = new Tile();
                tile[i].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(sprite_list[i])));
            }
//            tile[0] = new Tile();
//            tile[0].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/grass.png")));
//
//            tile[1] = new Tile();
//            tile[1].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/wall.png")));
//
//            tile[2] = new Tile();
//            tile[2].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/water.png")));
//
//            tile[3] = new Tile();
//            tile[3].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/earth.png")));
//
//            tile[4] = new Tile();
//            tile[4].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/tree.png")));
//
//            tile[5] = new Tile();
//            tile[5].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/sand.png")));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paint(Graphics2D g) {

        int screenX = 0;
        int screenY = 0;
        for (int j = 0; j < game.WORLD_ROW; j++) {
            for (int i = 0; i < game.WORLD_COL; i++) {
                int tileNum = mapTileNum[i][j];
                int worldX = i * game.TILESIZE;
                screenX = worldX - game.player.worldX + game.player.screenX;
                g.drawImage(tile[tileNum].image,screenX,screenY,game.TILESIZE,game.TILESIZE,null);
            }
            int worldY = j * game.TILESIZE;
            screenY = worldY - game.player.worldY + game.player.screenY;


        }

    }
}
