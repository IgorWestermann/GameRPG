package entity;

import main.Game;
import main.Input;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {
    Game game;
    Input input;

    public Player(Game game, Input input) {

        this.game = game;
        this.input = input;

        this.x = 100;
        this.y = 100;
        this.speed = 4;
        this.direction = "down";
        this.isIdle = true;

        load();
    }

    public void load() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/up/up_0.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/up/up_1.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/player/up/up_2.png"));
            up4 = ImageIO.read(getClass().getResourceAsStream("/player/up/up_3.png"));
            up_idle = ImageIO.read(getClass().getResourceAsStream("/player/up_idle/idle_up.png"));
            up_attack = ImageIO.read(getClass().getResourceAsStream("/player/up_attack/attack_up.png"));

            down1 = ImageIO.read(getClass().getResourceAsStream("/player/down/down_0.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/down/down_1.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/player/down/down_2.png"));
            down4 = ImageIO.read(getClass().getResourceAsStream("/player/down/down_3.png"));
            down_idle = ImageIO.read(getClass().getResourceAsStream("/player/down_idle/idle_down.png"));
            down_attack = ImageIO.read(getClass().getResourceAsStream("/player/down_attack/attack_down.png"));

            left1 = ImageIO.read(getClass().getResourceAsStream("/player/left/left_0.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/left/left_1.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/player/left/left_2.png"));
            left4 = ImageIO.read(getClass().getResourceAsStream("/player/left/left_3.png"));
            left_idle = ImageIO.read(getClass().getResourceAsStream("/player/left_idle/idle_left.png"));
            left_attack = ImageIO.read(getClass().getResourceAsStream("/player/left_attack/attack_left.png"));

            right1 = ImageIO.read(getClass().getResourceAsStream("/player/right/right_0.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/right/right_1.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/player/right/right_2.png"));
            right4 = ImageIO.read(getClass().getResourceAsStream("/player/right/right_3.png"));
            right_idle = ImageIO.read(getClass().getResourceAsStream("/player/right_idle/idle_right.png"));
            right_attack = ImageIO.read(getClass().getResourceAsStream("/player/right_attack/attack_right.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if (input.up) {
            y -= speed;
            direction = "up";
            isIdle = false;
        } else if (input.down) {
            y += speed;
            direction = "down";
            isIdle = false;
        } else if (input.left) {
            x -= speed;
            direction = "left";
            isIdle = false;
        } else if (input.right) {
            x += speed;
            direction = "right";
            isIdle = false;
        } else {
            isIdle = true;
        }

        spriteCounter++;
        if (spriteCounter > 12 && isIdle == false) {
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 3;
            } else if (spriteNum == 3) {
                spriteNum = 4;
            } else if (spriteNum == 4) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
    }

    public void paint(Graphics2D graphic) {
        BufferedImage image = null;
        if (direction == "up") {
            if (spriteNum == 1) {
                image = up1;
            }
            if (spriteNum == 2) {
                image = up2;
            }
            if (spriteNum == 3) {
                image = up3;
            }
            if (spriteNum == 4) {
                image = up4;
            }

        } else if (direction == "down") {
            if (spriteNum == 1) {
                image = down1;
            }
            if (spriteNum == 2) {
                image = down2;
            }
            if (spriteNum == 3) {
                image = down3;
            }
            if (spriteNum == 4) {
                image = down4;
            }
        } else if (direction == "left") {
            if (spriteNum == 1) {
                image = left1;
            }
            if (spriteNum == 2) {
                image = left2;
            }
            if (spriteNum == 3) {
                image = left3;
            }
            if (spriteNum == 4) {
                image = left4;
            }
        } else if (direction == "right") {
            if (spriteNum == 1) {
                image = right1;
            }
            if (spriteNum == 2) {
                image = right2;
            }
            if (spriteNum == 3) {
                image = right3;
            }
            if (spriteNum == 4) {
                image = right4;
            }
        }
        graphic.drawImage(image, x, y, game.TILESIZE, game.TILESIZE, null);
    }

}
