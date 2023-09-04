package gamestates;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public interface StateMethods {

    void draw(Graphics g);
    void update();
    void keyPressed(KeyEvent e);
    void keyReleased(KeyEvent e);
    void mousePressed(MouseEvent e);
    void mouseClicked(MouseEvent e);
    void mouseReleased(MouseEvent e);
    void mouseDragged(MouseEvent e);
}
