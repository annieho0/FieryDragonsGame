package player;

import dragonCards.Cards;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public abstract class Player extends Entity{
    protected GamePanel gp;
    protected BufferedImage dragonImage;
    protected PlayerTurn playerTurn;

    public Player(GamePanel gp, String imagePath, int startX, int startY) {
        this.gp = gp;
        this.playerTurn = playerTurn;
        setDefaultValues(startX, startY);
        getDragonImage(imagePath);
    }

    public abstract void update();

    public void draw(Graphics2D g2) {
        g2.drawImage(dragonImage, x, y, gp.tileSize, gp.tileSize, null);
    }

    protected void getDragonImage(String imagePath) {
        try {
            dragonImage = ImageIO.read(getClass().getResourceAsStream(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public PlayerTurn getPlayerTurn() {
        return playerTurn;
    }

    public void setPlayerTurn(PlayerTurn playerTurn) {
        this.playerTurn = playerTurn;
    }

    // Method to switch player turn
    public void switchPlayerTurn() {
        playerTurn = (playerTurn == PlayerTurn.PINK) ? PlayerTurn.PURPLE : PlayerTurn.PINK;
    }
    public boolean contains(int mouseX, int mouseY) {
        return mouseX >= x && mouseX <= x + gp.tileSize &&
                mouseY >= y && mouseY <= y + gp.tileSize;
    }


    protected void setDefaultValues(int startX, int startY) {
        x = startX * gp.tileSize;
        y = startY * gp.tileSize;
    }
    public void setCurrentPosition(int positionX, int positionY){
        x = positionX * gp.tileSize;
        y = positionY * gp.tileSize;
    }



    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

