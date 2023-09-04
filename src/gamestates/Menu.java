package gamestates;

import game.Game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import static utilz.Constants.GameConstants.*;

public class Menu extends State implements StateMethods{

    public Menu(Game game) {
        super(game);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
    }

    @Override
    public void update() {
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }
}
