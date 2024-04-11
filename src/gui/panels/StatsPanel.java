package gui.panels;

import gui.dataLabels.StatLabel;
import players.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import util.managers.ImageManager;

public class StatsPanel extends JPanel {
    private static StatsPanel instance;
    private JPanel rStats;
    private final Image image;
    private JLabel strLabel;
    private JLabel defLabel;
    private JLabel dexLabel;
    private JLabel pcritLabel;
    private JLabel helmetLabel;
    private JLabel chestLabel;
    private JLabel knucklesLabel;
    private JLabel weaponLabel;
    private JLabel expLabel;
    private JLabel classLabel;
    private JLabel goldLabel;
    private JPanel jstatspanel;
    private JLabel bootsLabel;
    private Player player;

    public StatsPanel(Player player) {
        image = ImageManager.getInstance().getImage("ssPanels");
        this.player = player;
        add(rStats);
        setOpaque(false);
        setBackground(null);
}
    public static StatsPanel getInstance (Player player) {

        if (instance == null) {

            instance = new StatsPanel(player);
        }
        return instance;
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

    public void update() {


    }

    private void createUIComponents() {
    }
}
