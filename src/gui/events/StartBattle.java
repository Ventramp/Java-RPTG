package gui.events;

import enemies.Enemies;
import gui.GeneralScreen;
import gui.PlayerPanel;
import gui.panels.*;
import players.Player;
import util.enemies.EnemyFactory;
import util.managers.ImageManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartBattle {
public static StartBattle instance;
private Player player;
private Enemies enemies;

    public StartBattle(Player player,Enemies enemies) {
        this.player = player;
        this.enemies= enemies;
    }

    public static StartBattle getInstance(Player player, Enemies enemies) {

        if (instance == null) {

            instance = new StartBattle(player, enemies);
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
                enemies.displayData();
            }
        });
    }
    public void huir(){
        ButtonsPanel.getInstance(player, enemies).getButton3().removeActionListener(ButtonsPanel.getInstance(player, enemies).getButton3().getActionListeners()[0]);
        ButtonsPanel.getInstance(player, enemies).getButton3().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.escape(enemies);
                if (enemies.eDie()) {
                    enemies = EnemyFactory.generateRegularEnemy(player);
                    GeneralScreen.getInstance().setEnemies(enemies);
                    EnemyPanel.getInstance(enemies).updateEnemy(enemies);
                    ButtonsPanel.getInstance(player,enemies).changeButtons();
                }else {
                    StartBattle.getInstance(player,enemies).changeButtons();
                    EnemyPanel.getInstance(enemies).updateEnemy();
                }
                StatusPanel.getInstance(player, PlayerPanel.getInstance(),0).updatePlayer(player);
                StatsPanel.getInstance(player,PlayerPanel.getInstance(), 1).update();
                EnemyPanel.getInstance(enemies).updateEnemy(enemies);
                EnemyPanel.getInstance(enemies).updateEnemy();
            }
        });
    }
    }

