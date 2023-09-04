package game;

import gamestates.GameState;
import gamestates.Menu;
import gamestates.Playing;
import inputs.KeyboardInputs;
import inputs.MouseInputs;

import java.awt.*;

public class Game implements Runnable{
    private final GameWindow gameWindow;
    private final GamePanel gamePanel;
    private MouseInputs mouseInputs;
    private KeyboardInputs keyboardInputs;


    private Playing playing;
    private Menu menu;



    public Game() {
        initClasses();

        gamePanel = new GamePanel(this);
        gameWindow = new GameWindow(gamePanel);

        initInputs();
    }

    private void initClasses() {
        playing = new Playing(this);
        mouseInputs = new MouseInputs(this);
        keyboardInputs = new KeyboardInputs(this);
    }

    private void initInputs() {
        gamePanel.addMouseListener(mouseInputs);
        gamePanel.addKeyListener(keyboardInputs);

        gamePanel.setFocusable(true);
        gamePanel.requestFocus();
    }

    public void draw(Graphics g) {
        playing.draw(g);
    }

    public void update() {
        switch (GameState.state) {

        }
        playing.update();
    }

    @Override
    public void run() {
        while (true) {
            update();
            gamePanel.repaint();
        }
    }

    public Playing getPlaying() {
        return playing;
    }

    public Menu getMenu() {
        return menu;
    }
}
