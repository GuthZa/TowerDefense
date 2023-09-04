package gamestates;

import game.Game;
import utilz.LoadSave;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;

import static utilz.Constants.GameConstants.*;

public class Playing extends State implements StateMethods{
    private BufferedImage spriteAtlas;
    private ArrayList<BufferedImage> sprites = new ArrayList<>();
    private int[][] levelData;

    public Playing(Game game) {
        super(game);
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

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics g) {
        drawBackground(g);

        for (int y = 0; y < GAME_WIDTH / TILE_SIZE; y++) {
            for (int x = 0; x < GAME_HEIGHT / TILE_SIZE; x++) {
                int value = levelData[x][y];
                if (value == 1)
                    g.drawImage(sprites.get(value),
                        x * TILE_SIZE, y * TILE_SIZE,
                        TILE_SIZE, TILE_SIZE, null);
            }
        }
    }

    private void drawBackground(Graphics g) {
        for (int i = 0; i < levelData.length; i++) {
            for (int j = 0; j < levelData[0].length; j++) {
                g.setColor(Color.darkGray);
                g.drawImage(sprites.get(9), i * TILE_SIZE, j * TILE_SIZE, TILE_SIZE, TILE_SIZE, null);
                g.drawRect(i * TILE_SIZE, j * TILE_SIZE, TILE_SIZE, TILE_SIZE);
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        levelData[e.getX() / TILE_SIZE][e.getY() / TILE_SIZE] = 1;
        System.out.println("moused pressed");
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }
}
