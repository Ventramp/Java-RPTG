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

public class AttackMenu {
    public static AttackMenu instance;
    private Player player;
    private Enemies enemies;


    public AttackMenu(Player player, Enemies enemies) {
        this.player = player;
        this.enemies= enemies;
    }

    public static AttackMenu getInstance(Player player, Enemies enemies) {

        if (instance == null) {

            instance = new AttackMenu(player, enemies);
        }
        return instance;
    }

    public void changeButtons() {
        ButtonsPanel.getInstance(player, enemies).getButton1().setIcon(new ImageIcon(ImageManager.getInstance().getImage("golpe")));
        ButtonsPanel.getInstance(player, enemies).getButton2().setIcon(new ImageIcon(ImageManager.getInstance().getImage("artilleria")));
        ButtonsPanel.getInstance(player, enemies).getButton3().setIcon(new ImageIcon(ImageManager.getInstance().getImage("regresar")));
        golpe();
        artilleria();
        regresar();
    }
    public void golpe(){
        ButtonsPanel.getInstance(player, enemies).getButton1().removeActionListener(ButtonsPanel.getInstance(player, enemies).getButton1().getActionListeners()[0]);
        ButtonsPanel.getInstance(player, enemies).getButton1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    player.attack(enemies);
                if (enemies.eDie()) {
                    enemies = EnemyFactory.generateRegularEnemy(player);
                    GeneralScreen.getInstance().setEnemies(enemies);
                    EnemyPanel.getInstance(enemies).updateEnemy(enemies);
                    ButtonsPanel.getInstance(player,enemies).changeButtons();
                }else {
                    enemies.eAttack(player);
                    EnemyPanel.getInstance(enemies).updateEnemy();
                    StartBattle.getInstance(player,enemies).changeButtons();
                }
                StatusPanel.getInstance(player, PlayerPanel.getInstance(),0).updatePlayer(player);
                StatsPanel.getInstance(player,PlayerPanel.getInstance(), 1).update();
                EnemyPanel.getInstance(enemies).updateEnemy(enemies);
                EnemyPanel.getInstance(enemies).updateEnemy();
                    }
            });
    }
    public void artilleria(){
        ButtonsPanel.getInstance(player, enemies).getButton2().removeActionListener(ButtonsPanel.getInstance(player, enemies).getButton2().getActionListeners()[0]);
        ButtonsPanel.getInstance(player, enemies).getButton2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArtilleryMenu.getInstance(player, enemies).changeButtons();
            }
        });
    }
    public void regresar(){
        ButtonsPanel.getInstance(player, enemies).getButton3().removeActionListener(ButtonsPanel.getInstance(player, enemies).getButton3().getActionListeners()[0]);
        ButtonsPanel.getInstance(player, enemies).getButton3().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StartBattle.getInstance(player, enemies).changeButtons();
            }
        });
    }
}

