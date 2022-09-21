package entity;

import java.awt.image.BufferedImage;

public class Entity {
    public int worldX, worldY, speed;
    public boolean isIdle;

    public BufferedImage up1, up2, up3, up4, up_idle, up_attack;
    public BufferedImage down1, down2, down3, down4, down_idle, down_attack;
    public BufferedImage left1, left2, left3, left4, left_idle, left_attack;
    public BufferedImage right1, right2, right3, right4, right_idle, right_attack;

    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;
}
