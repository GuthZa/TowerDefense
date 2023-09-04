package utilz;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LoadSave {

    public static final String SPRITE_ATLAS = "resources/spriteatlas.png";

    public static BufferedImage GetSpriteAtlas(String filename) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(filename));
        } catch (IOException e) {
            System.out.println("Error loading player image at: ");
            e.printStackTrace();
        }
        return image;
    }
}
