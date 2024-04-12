package gui.panels;

import javax.swing.*;
import java.awt.*;

import enemies.Enemies;
import enemies.pirate.San;
import gui.dataLabels.SpriteLabel;
import players.Player;
import util.managers.ImageManager;

public class EnemyPanel extends JPanel {
    private static EnemyPanel instance;
    private final Image image;
    private Enemies enemies;
    private Player player;
    private JPanel rEnemy;
    private JPanel spritePanel;
    private JLabel enemySpriteLabel;

    public EnemyPanel(Enemies enemies){
        this.enemies = enemies;
    image = ImageManager.getInstance().getImage("gamePanel");
        Dimension size = new Dimension(image.getWidth(null), image.getHeight(null));
        setPreferredSize(size);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
    add(rEnemy);
    setOpaque(false);

    }
    public static EnemyPanel getInstance(Enemies enemies) {

        if (instance == null) {

            instance = new EnemyPanel(enemies);
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

    private void createUIComponents() {
        enemySpriteLabel = new SpriteLabel(enemies.getImage());
    }
}
