package game;

import gamestates.GameState;
import gamestates.Menu;
import gamestates.Playing;
import inputs.KeyboardInputs;
import inputs.MouseInputs;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import static utilz.Constants.*;

public class Game implements Runnable{
    private final GameWindow gameWindow;
    private final GamePanel gamePanel;
    private Thread gameThread;

    private MouseInputs mouseInputs;
    private KeyboardInputs keyboardInputs;


    private Playing playing;
    private Menu menu;



    public Game() {
        initClasses();

        gamePanel = new GamePanel(this);
        gameWindow = new GameWindow(gamePanel);

        initInputs();
        gamePanel.setFocusable(true);
        gamePanel.requestFocus();
        startGameLoop();
    }

    private void initClasses() {
        playing = new Playing(this);
        menu = new Menu(this);
        mouseInputs = new MouseInputs(this);
        keyboardInputs = new KeyboardInputs(this);
    }

    private void initInputs() {
        gamePanel.addMouseListener(mouseInputs);
        gamePanel.addKeyListener(keyboardInputs);
    }

    private void startGameLoop() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void draw(Graphics g) {
        switch (GameState.state) {
            case PLAYING -> playing.draw(g);
            case MENU -> menu.draw(g);
        }
    }

    public void update() {
        switch (GameState.state) {
            case PLAYING -> playing.update();
            case MENU -> menu.update();
        }
        playing.update();
    }

    @Override
    public void run() {
        double timePerFrame = 1000000000.0 / FPS;
        double timePerUpdate = 1000000000.0 / UPS;

        long previousTime = System.nanoTime();

        int frames = 0;
        int updates = 0;
        long lastCheck = System.currentTimeMillis();

        double deltaU = 0;
        double deltaF = 0;

        while (true) {
            long currentTime = System.nanoTime();

            deltaU += (currentTime - previousTime) / timePerUpdate;
            deltaF += (currentTime - previousTime) / timePerFrame;
            previousTime = currentTime;

            if (deltaU >= 1) {
                update();
                updates++;
                deltaU--;
            }

            if (deltaF >= 1) {
                gamePanel.repaint();
                frames++;
                deltaF--;
            }

            if (System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames + " | UPS: " + updates);
                frames = 0;
                updates = 0;

            }
        }

    }

    //Inputs
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> GameState.state = GameState.PLAYING;
            case KeyEvent.VK_A -> GameState.state = GameState.MENU;
        }
        System.out.println("key pressed");
    }

    public void keyReleased(KeyEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
        playing.mousePressed(e);
    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseDragged(MouseEvent e) {
        System.out.println("mouse dragged: " + e.getButton());
    }
    public void mouseEntered(MouseEvent e) {

    }
    public void mouseExited(MouseEvent e) {

    }


    //Getters & Setters
    public Playing getPlaying() {
        return playing;
    }

    public Menu getMenu() {
        return menu;
    }
}
