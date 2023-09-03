package game;

import java.awt.*;

public class Game {
    private final GameWindow gameWindow;
    private final GamePanel gamePanel;
    public Game() {
        gameWindow = new GameWindow(this);
        gamePanel = new GamePanel(this);

        gameWindow.add(gamePanel);

    }

    public void draw(Graphics g) {}



}
