package gui.events;

import enemies.Enemies;
import gui.panels.ButtonsPanel;
import gui.panels.ConsolePanel;
import players.Player;
import util.managers.ImageManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ArtilleryMenu {
    public static ArtilleryMenu instance;
    private Player player;
    private Enemies enemies;

    public ArtilleryMenu(Player player, Enemies enemies) {
        this.player = player;
        this.enemies = enemies;
    }

    public static ArtilleryMenu getInstance(Player player, Enemies enemies) {

        if (instance == null) {

            instance = new ArtilleryMenu(player, enemies);
        }
        return instance;
    }
    public void changeButtons(){
        ButtonsPanel.getInstance(player, enemies).getButton1().setIcon(new ImageIcon(ImageManager.getInstance().getImage("aNormal")));
        ButtonsPanel.getInstance(player, enemies).getButton2().setIcon(new ImageIcon(ImageManager.getInstance().getImage("aCargado")));
        ButtonsPanel.getInstance(player, enemies).getButton3().setIcon(new ImageIcon(ImageManager.getInstance().getImage("regresar")));
        normal();
        cargado();
        regresar();
    }
    public void normal(){
        ButtonsPanel.getInstance(player, enemies).getButton1().removeActionListener(ButtonsPanel.getInstance(player, enemies).getButton1().getActionListeners()[0]);
        ButtonsPanel.getInstance(player, enemies).getButton1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.gun(enemies);
            }
        });
    }
    public void cargado(){
        ButtonsPanel.getInstance(player, enemies).getButton2().removeActionListener(ButtonsPanel.getInstance(player, enemies).getButton2().getActionListeners()[0]);
        ButtonsPanel.getInstance(player, enemies).getButton2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.canyon(enemies);
            }
        });
    }
    public void regresar(){
        ButtonsPanel.getInstance(player, enemies).getButton3().removeActionListener(ButtonsPanel.getInstance(player, enemies).getButton3().getActionListeners()[0]);
        ButtonsPanel.getInstance(player, enemies).getButton3().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AttackMenu.getInstance(player, enemies).changeButtons();
            }
        });
    }
}
