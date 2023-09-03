package game;

import javax.swing.*;
import java.awt.*;

import static utilz.Constants.GameConstants.GAME_HEIGHT;
import static utilz.Constants.GameConstants.GAME_WIDTH;

public class GameWindow extends JFrame {
    private Game game;

    public GameWindow(Game game) throws HeadlessException {
        this.game = game;

        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }


}
