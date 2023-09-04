package game;

import gamestates.Playing;
import inputs.MouseInputs;

import java.awt.*;
import java.awt.event.MouseListener;

public class Game implements Runnable{
    private final GameWindow gameWindow;
    private final GamePanel gamePanel;
    private MouseListener mouseListener;


    private Playing playing;



    public Game() {
        initClasses();

        gamePanel = new GamePanel(this);
        gameWindow = new GameWindow(gamePanel);

        gamePanel.setFocusable(true);
        gamePanel.requestFocus();

        gamePanel.addMouseListener(mouseListener);
    }

    private void initClasses() {
        playing = new Playing(this);
        mouseListener = new MouseInputs(this);
    }

    public void draw(Graphics g) {
        playing.draw(g);
    }

    public void update() {
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
}
