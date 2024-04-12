package gui.panels;

import gui.PlayerPanel;
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
    private final PlayerPanel playerPanel;
    private final int tabIndex;
    private final ImageIcon activeIcon;
    private final ImageIcon inactiveIcon;
    private JLabel strLabel;
    private JLabel defLabel;
    private JLabel dexLabel;
    private JLabel pcritLabel;
    private JLabel helmetLabel;
    private JLabel chestLabel;
    private JLabel knucklesLabel;
    private JLabel weaponLabel;
    private JLabel goldLabel;
    private JPanel jstatspanel;
    private JLabel bootsLabel;
    private Player player;

    public StatsPanel(Player player, PlayerPanel playerPanel, int tabIndex) {
        this.player = player;
        add(rStats);
        setOpaque(false);
        setBackground(null);
        this.tabIndex = tabIndex;
        ImageManager imageManager = ImageManager.getInstance();
        this.activeIcon = new ImageIcon(imageManager.getImage("statsBActive"));
        this.inactiveIcon = new ImageIcon(imageManager.getImage("statsBInactive"));
        this.playerPanel = playerPanel;
        setOpaque(false);
        setBackground(null);
        setMixingCutoutShape(new Rectangle(0, 0, 0, 0));
        playerPanel.addTab("Estatus",this);
        playerPanel.setTabIcon(tabIndex,isActive() ? activeIcon:inactiveIcon);
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {

                playerPanel.setTabIcon(tabIndex, activeIcon);
            }

            @Override
            public void componentHidden(ComponentEvent e) {

                playerPanel.setTabIcon(tabIndex, inactiveIcon);
            }
        });
    }
    private boolean isActive() {

        return playerPanel.getSelectedIndex() == tabIndex;
    }
    public static StatsPanel getInstance (Player player,PlayerPanel playerPanel, int tabIndex) {

        if (instance == null) {

            instance = new StatsPanel(player,playerPanel,tabIndex);
        }
        return instance;
    }

    public void update() {
    }

    private void createUIComponents() {
        strLabel = new StatLabel(player.getTotalStr(),
                ImageManager.getInstance().getImage("attackHolder"));
        defLabel = new StatLabel(player.getTotalDeff(),
                ImageManager.getInstance().getImage("defenseHolder"));
        goldLabel = new StatLabel("ORO: " + player.getGold(),
                ImageManager.getInstance().getImage("goldHolder"));
        pcritLabel = new StatLabel(player.getTotalPcrit(),
                ImageManager.getInstance().getImage("luckHolder"));
        dexLabel = new StatLabel(player.getTotalDex(),
                ImageManager.getInstance().getImage("dexterityHolder"));
        weaponLabel = new StatLabel("ARMA: " + player.getWeapon().getName(),
                ImageManager.getInstance().getImage("weaponHolder"));
        helmetLabel = new StatLabel("CABEZA: " + player.getHelmet().getName(),
                ImageManager.getInstance().getImage("headArmorHolder"));
        chestLabel = new StatLabel("PECHO: " + player.getChest().getName(),
                ImageManager.getInstance().getImage("chestArmorHolder"));
        bootsLabel = new StatLabel("PIERNAS: " + player.getBoots().getName(),
                ImageManager.getInstance().getImage("legArmorHolder"));
        knucklesLabel = new StatLabel("MANOS: " + player.getKnuckles().getName(),
                ImageManager.getInstance().getImage("handArmorHolder"));
    }
}
