package graphInterface.panels;

import players.Player;
import graphInterface.dataLabels.StatLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class StatsPanel extends JPanel{
    private static StatsPanel instance;
    private JPanel rStats;
    private JLabel hpLabel;
    private JLabel apLabel;
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
    private Player player;

    public StatsPanel() {

    }
    public static StatsPanel getInstance() {

        if (instance == null) {

            instance = new StatsPanel();
        }
        return instance;
    }
    private void createUIComponents() {
        expLabel = new StatLabel("EXP: " + player.getExp();
        strLabel = new StatLabel(player.getAttk();
        defLabel = new StatLabel(player.getDef();
    }
}
