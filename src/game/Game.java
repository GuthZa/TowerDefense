package game;

import gamestates.GameState;
import gamestates.Menu;
import gamestates.Playing;
import inputs.KeyboardInputs;
import inputs.MouseInputs;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

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

        gamePanel.setFocusable(true);
        gamePanel.requestFocus();
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
        while (true) {
            update();
            gamePanel.repaint();
        }
    }

    //Inputs
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> {
                System.out.println("w pressed");
                GameState.state = GameState.PLAYING;
            }
            case KeyEvent.VK_A -> {
                System.out.println("a pressed");
                GameState.state = GameState.MENU;
            }
        }
    }

    public void keyReleased(KeyEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
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
