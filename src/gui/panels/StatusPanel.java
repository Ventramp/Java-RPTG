package gui.panels;

import gui.dataLabels.TextLabel;
import players.Player;
import gui.dataLabels.PortraitLabel;
import util.managers.ImageManager;

import javax.swing.*;
import java.awt.*;

public class StatusPanel  extends JPanel{
    private static StatusPanel instance;
    private final Image image;
    private Player player;

    private JLabel apLabel;
    private JPanel rStatus;
    private JLabel portraitLabel;

    public static StatusPanel getInstance(Player player) {

        if (instance == null) {

            instance = new StatusPanel(player);
        }
        return instance;
    }

    public StatusPanel(Player player) {
        image = ImageManager.getInstance().getImage("ssPanels2");
        Dimension size = new Dimension(image.getWidth(null), image.getHeight(null));
        setPreferredSize(size);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        this.player = player;
        setOpaque(false);
        add(rStatus);
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
    public void updatePlayer(Player player) {
        this.player = player;
    }

    private void createUIComponents() {
        portraitLabel = PortraitLabel.getInstance();
    }
}
