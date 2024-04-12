package gui;

import players.Player;
import gui.GameTab;
import util.managers.ImageManager;

import javax.swing.*;
import java.awt.*;

public class PlayerPanel extends JTabbedPane {
    private static PlayerPanel instance;
    private final Image image;
    public static PlayerPanel getInstance() {

        if (instance == null) {

            instance = new PlayerPanel();
        }
        return instance;
    }

    public PlayerPanel() {
        super();
        image = ImageManager.getInstance().getImage("ssPanels");
        Dimension size = new Dimension(420, 800);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setOpaque(false);
        setBorder(null);
        setUI(new gui.GameTab());
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
    public void setTabIcon(int index, ImageIcon icon) {

        JLabel label = new JLabel(icon);
        Dimension size = new Dimension(icon.getIconWidth(), icon.getIconHeight());
        label.setPreferredSize(size);
        label.setMinimumSize(size);
        label.setMaximumSize(size);
        label.setSize(size);
        setTabComponentAt(index, label);
        addChangeListener(e -> {
            if (getSelectedIndex() == index) {
                label.setIcon(icon);
            }
        });
    }
}
