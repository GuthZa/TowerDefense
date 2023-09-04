package inputs;

import game.Game;
import game.GamePanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInputs implements MouseListener, MouseMotionListener {

    private Game game;

    public MouseInputs(Game game) {
        this.game = game;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //registers when there's a press and release
        game.mouseClicked(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        game.mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        game.mouseReleased(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        game.mouseEntered(e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        game.mouseExited(e);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        game.mouseDragged(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //mouse is moved and button not pressed
    }
}
