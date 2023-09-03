package game;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    private Game game;

    public GameWindow(Game game) throws HeadlessException {
        this.game = game;

        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }


}
