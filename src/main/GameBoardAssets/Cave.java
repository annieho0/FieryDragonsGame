package main.GameBoardAssets;

import java.awt.*;

public class Cave {
    int caveX;
    int caveY;
    int caveWidth;
    int caveHeight;

    public Cave(int caveX, int caveY, int caveWidth, int caveHeight) {
        this.caveX = caveX;
        this.caveY = caveY;
        this.caveWidth = caveWidth;
        this.caveHeight = caveHeight;
    }

    public void draw(Graphics2D g2) {
        // drawing the cave
        g2.setColor(Color.WHITE);
        g2.drawOval(caveX,caveY, caveWidth, caveHeight);

    }
}