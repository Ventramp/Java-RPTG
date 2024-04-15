package gui.panels;

import gui.PlayerPanel;
import gui.dataLabels.ApLabel;
import gui.dataLabels.HpLabel;
import gui.dataLabels.TextLabel;
import players.Player;
import gui.dataLabels.PortraitLabel;
import util.managers.ImageManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class StatusPanel  extends JPanel{
    private static StatusPanel instance;
    private final PlayerPanel playerPanel;
    private final int tabIndex;
    private final ImageIcon activeIcon;
    private final ImageIcon inactiveIcon;
    private Player player;

    private JLabel apLabel;
    private JPanel rStatus;
    private JLabel portraitLabel;
    private JLabel playerName;
    private JLabel jobLabel;
    private JLabel hpLabel;
    private JLabel levelLabel;

    public static StatusPanel getInstance(Player player, PlayerPanel playerPanel, int tabIndex) {

        if (instance == null) {

            instance = new StatusPanel(player,playerPanel,tabIndex);
        }
        return instance;
    }

    public StatusPanel(Player player, PlayerPanel playerPanel, int tabIndex) {
        this.player = player;
        this.tabIndex = tabIndex;
        ImageManager imageManager = ImageManager.getInstance();
        this.activeIcon = new ImageIcon(imageManager.getImage("statusBActive"));
        this.inactiveIcon = new ImageIcon(imageManager.getImage("statusBInactive"));
        this.playerPanel = playerPanel;
        add(rStatus);
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

    public void updatePlayer(Player player) {
        playerName =new TextLabel(player.getName(), "textHolder");
        this.player = player;
        ((HpLabel) hpLabel).updateCharacter(player);
        ((ApLabel) apLabel).updateCharacter(player);
        apLabel.repaint();
        ((TextLabel)levelLabel).setDisplayText(String.format("Nivel: %d", player.getLevel()));
        levelLabel.repaint();
    }

    private void createUIComponents() {
        rStatus = new JPanel();
        rStatus.setOpaque(false);
        rStatus.setBackground(null);
        rStatus.setMixingCutoutShape(new Rectangle(0, 0, 0, 0));
        portraitLabel = PortraitLabel.getInstance();
        playerName = new TextLabel(player.getName(), "textHolder");
        levelLabel = new TextLabel(String.format("Nivel: %d", player.getLevel()), "textHolder");
        if (player.getJob() != null) {

            jobLabel = new TextLabel(player.getJob(), "jobHolder");
        } else {
            jobLabel = new TextLabel("Aventurero", "jobHolder");
        }
        hpLabel = new HpLabel(player);
        apLabel = ApLabel.getInstance(player);
    }
}
