package uet.oop.bomberman;

import javafx.event.ActionEvent;
import uet.oop.bomberman.GamePanel;
import uet.oop.bomberman.entities.ResourceCollection;
import uet.oop.bomberman.entities.Sound;

import javax.swing.*;
import java.awt.*;

public class Controller {

    static GameWindow window;

    public void startgame(ActionEvent actionEvent) throws Exception {

        ResourceCollection.readFiles();
        ResourceCollection.init();
        GamePanel game;
        game = new GamePanel();
        game.init();

        Sound s = new Sound();
        try {
            s.play(Sound.BACKGROUND, 3);
        } catch (Exception e) {
            e.printStackTrace();
        }


        window = new GameWindow(game);

        System.gc();
    }
}



class GameWindow extends JFrame {

    /**
     * Screen width and height is determined by the map size. Map size is set when loading the map in
     * the GamePanel class. For best results, do not use a map that is smaller than the default map
     * provided in resources.
     */

    static final int HUD_HEIGHT = 48;   // Size of the HUD. The HUD displays score.
    static final String TITLE = "Bomberman by GGAA TEAM";

    /**
     * Constructs a game window with the necessary configurations.
     * @param game Game panel that will be contained inside the game window
     */
    GameWindow(GamePanel game) {
        this.setTitle(TITLE);
        this.setIconImage(ResourceCollection.Images.ICON.getImage());
        this.setLayout(new BorderLayout());
        this.add(game, BorderLayout.CENTER);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}

