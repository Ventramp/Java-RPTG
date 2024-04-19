package gui.events;

import enemies.Enemies;
import gui.PlayerPanel;
import gui.panels.ButtonsPanel;
import gui.panels.StatsPanel;
import items.armors.boots.EmpyBoots;
import items.armors.boots.LeatherBoots;
import players.Player;
import util.managers.ImageManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShopMenu {
    public static ShopMenu instance;
    private Player player;
    private Enemies enemies;

    public ShopMenu(Player player, Enemies enemies) {
        this.player = player;
        this.enemies = enemies;
    }

    public static ShopMenu getInstance(Player player, Enemies enemies) {

        if (instance == null) {

            instance = new ShopMenu(player, enemies);
        }
        return instance;
    }
    public void changeButtons(){
        ButtonsPanel.getInstance(player, enemies).getButton1().setIcon(new ImageIcon(ImageManager.getInstance().getImage("comprar")));
        ButtonsPanel.getInstance(player, enemies).getButton2().setIcon(new ImageIcon(ImageManager.getInstance().getImage("vender")));
        ButtonsPanel.getInstance(player, enemies).getButton3().setIcon(new ImageIcon(ImageManager.getInstance().getImage("regresar")));
        comprar();
        vender();
        regresar();
    }
    public void comprar(){
        ButtonsPanel.getInstance(player, enemies).getButton1().removeActionListener(ButtonsPanel.getInstance(player, enemies).getButton1().getActionListeners()[0]);
        ButtonsPanel.getInstance(player, enemies).getButton1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            Shop.getInstance().buy(player);
                StatsPanel.getInstance(player, PlayerPanel.getInstance(),1).update();
            }
        });
    }
    public void vender(){
        ButtonsPanel.getInstance(player, enemies).getButton2().removeActionListener(ButtonsPanel.getInstance(player, enemies).getButton2().getActionListeners()[0]);
        ButtonsPanel.getInstance(player, enemies).getButton2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            Shop.getInstance().sell(player);
                StatsPanel.getInstance(player, PlayerPanel.getInstance(),1).update();
            }
        });
    }
    public void regresar(){
        ButtonsPanel.getInstance(player, enemies).getButton3().removeActionListener(ButtonsPanel.getInstance(player, enemies).getButton3().getActionListeners()[0]);
        ButtonsPanel.getInstance(player, enemies).getButton3().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InventoryMenu.getInstance(player,enemies).changeButtons();
            }
        });
    }
}
