package game;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    private GamePanel gamePanel;

    public GameWindow(GamePanel gamePanel) throws HeadlessException {
        this.gamePanel = gamePanel;

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(gamePanel);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
