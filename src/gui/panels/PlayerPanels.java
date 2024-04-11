package gui.panels;

import players.Player;
import util.managers.ImageManager;
import javax.swing.*;
import java.awt.*;

import static javax.swing.text.StyleConstants.setBackground;

public class PlayerPanels extends JPanel{
    private static PlayerPanels instance;
    private final Image image;
    private Player player;
    private JPanel rPlayer;
    private JTabbedPane playerJtabbed;
    private JPanel statsPanel;
    private JPanel statusPanel;

    public static PlayerPanels getInstance () {

        if (instance == null) {

            instance = new PlayerPanels();
        }
        return instance;
    }
    public PlayerPanels() {
        image = ImageManager.getInstance().getImage("ssPanels");
        add(rPlayer);
    }
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        paintBackground(g2d);
    }

    public void paintBackground(Graphics2D g2d) {

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2d.drawImage(image, 0, 0, null);
    }

    private void createUIComponents() {
        statsPanel = StatsPanel.getInstance(player);
        statusPanel = StatusPanel.getInstance(player);
    }
}
