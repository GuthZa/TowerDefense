package gamestates;

import game.Game;
import utilz.LoadSave;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static utilz.Constants.GameConstants.*;

public class Playing {
    private Game game;

    private BufferedImage spriteAtlas;
    private ArrayList<BufferedImage> sprites = new ArrayList<>();
    private int[][] levelData;

    public Playing(Game game) {
        this.game = game;
        importImages();
        loadSprites();
        levelData = new int[20][20];
    }

    private void importImages() {
        spriteAtlas = LoadSave.GetSpriteAtlas(LoadSave.SPRITE_ATLAS);
    }

    private void loadSprites() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 10; j++) {
                sprites.add(spriteAtlas.getSubimage(j * TILE_SIZE, i * TILE_SIZE, TILE_SIZE, TILE_SIZE));
            }
        }
    }

    public void update() {

    }

    public void draw(Graphics g) {
        g.setColor(Color.green);
        for (int i = 0; i < levelData.length; i++) {
            for (int j = 0; j < levelData[0].length; j++) {

                g.setColor(Color.darkGray);
                g.drawImage(sprites.get(9), i * TILE_SIZE, j * TILE_SIZE, TILE_SIZE, TILE_SIZE, null);
                g.drawRect(i * TILE_SIZE, j * TILE_SIZE, TILE_SIZE, TILE_SIZE);
            }
        }
//        g.drawImage(spriteAtlas, 0, 0, 352, 96, null);
    }
}
