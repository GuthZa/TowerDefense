package tiles;

import utilz.LoadSave;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static utilz.Constants.GameConstants.TILE_SIZE;

public class TileManager {

    public Tile GRASS, WATER, ROAD;
    public BufferedImage spriteAtlas;
    public ArrayList<Tile> tiles = new ArrayList<>();

    public TileManager() {
        loadAtlas();
        createTiles();
    }

    private void loadAtlas() {
        spriteAtlas = LoadSave.GetSpriteAtlas(LoadSave.SPRITE_ATLAS);
    }

    private void createTiles() {
        tiles.add(GRASS = new Tile(getSprite(8, 1)));
        tiles.add(ROAD = new Tile(getSprite(6, 0)));
        tiles.add(WATER = new Tile(getSprite(9, 8)));
    }
    private BufferedImage getSprite(int x, int y) {
        return LoadSave.GetSpriteAtlas(LoadSave.SPRITE_ATLAS).
                getSubimage(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
    }

    public BufferedImage getSprite(int id) {
        return tiles.get(id).getSprite();
    }
}
