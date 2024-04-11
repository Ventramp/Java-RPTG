package gui.panels;

import enemies.Enemies;

import javax.swing.*;

import players.Player;

import java.awt.*;

public class ButtonsPanel extends JPanel {
    private static ButtonsPanel instance;
    private JPanel rButtons;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private Enemies enemies;
    private Player player;

    public ButtonsPanel() {
        add(rButtons);
        setOpaque(false);
        setBackground(null);
        setMixingCutoutShape(new Rectangle(0, 0, 0, 0));
    }


    public static ButtonsPanel getInstance() {

        if (instance == null) {

            instance = new ButtonsPanel();
        }
        return instance;
    }
}
