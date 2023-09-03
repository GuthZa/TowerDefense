package game;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private Game game;

    public GamePanel(Game game) {
        this.game = game;
    }

    public void update() {

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.gray);

        g.setColor(Color.black);
        g.fillRect(10, 20, 100, 100);
    }
}
