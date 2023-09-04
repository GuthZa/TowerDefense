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
        game.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        game.draw(g);
    }

    public Game getGame() {
        return game;
    }
}
