package gui.events;

import enemies.Enemies;
import gui.panels.ButtonsPanel;
import gui.panels.ConsolePanel;
import players.Player;
import util.managers.ImageManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartBattle {
public static StartBattle instance;
private Player player;
private Enemies enemies;

    public StartBattle(Player player) {
        this.player = player;
    }

    public static StartBattle getInstance(Player player) {

        if (instance == null) {

            instance = new StartBattle(player);
        }
        return instance;
    }
public void changeButtons(){
    ButtonsPanel.getInstance(player, enemies).getButton1().setIcon(new ImageIcon(ImageManager.getInstance().getImage("ataque")));
    ButtonsPanel.getInstance(player, enemies).getButton2().setIcon(new ImageIcon(ImageManager.getInstance().getImage("libra")));
    ButtonsPanel.getInstance(player, enemies).getButton3().setIcon(new ImageIcon(ImageManager.getInstance().getImage("huir")));
    ataque();
    libra();
    huir();
}
public void ataque(){
    ButtonsPanel.getInstance(player, enemies).getButton1().removeActionListener(ButtonsPanel.getInstance(player, enemies).getButton1().getActionListeners()[0]);
    ButtonsPanel.getInstance(player, enemies).getButton1().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        AttackMenu.getInstance(player, enemies).changeButtons();
        }
    });
}
    public void libra(){
        ButtonsPanel.getInstance(player, enemies).getButton2().removeActionListener(ButtonsPanel.getInstance(player, enemies).getButton2().getActionListeners()[0]);
        ButtonsPanel.getInstance(player, enemies).getButton2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConsolePanel.getInstance().getConsole().append(player.getName()+" uso Libra.\n");
            }
        });
    }
    public void huir(){
        ButtonsPanel.getInstance(player, enemies).getButton3().removeActionListener(ButtonsPanel.getInstance(player, enemies).getButton3().getActionListeners()[0]);
        ButtonsPanel.getInstance(player, enemies).getButton3().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConsolePanel.getInstance().getConsole().append(player.getName()+" huyo del combate.\n");
            }
        });
    }
    }

