package game;

import javax.swing.*;
import java.awt.*;

import static utilz.Constants.GameConstants.*;

public class GamePanel extends JPanel {

    private Game game;

    public GamePanel(Game game) {
        this.game = game;
        setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));

    }

    public void update() {

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.gray);

        g.setColor(Color.red);

        for (int i = 0; i < GAME_WIDTH / TILE_SIZE; i++) {
            for (int j = 0; j < GAME_HEIGHT / TILE_SIZE; j++) {
                g.drawRect(i * TILE_SIZE, j * TILE_SIZE, TILE_SIZE, TILE_SIZE);
            }
        }
    }
}
