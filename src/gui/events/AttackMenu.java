package gui.events;

import gui.panels.ButtonsPanel;
import gui.panels.ConsolePanel;
import players.Player;
import util.managers.ImageManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AttackMenu {
    public static AttackMenu instance;
    private Player player;

    public AttackMenu(Player player) {
        this.player = player;
    }

    public static AttackMenu getInstance(Player player) {

        if (instance == null) {

            instance = new AttackMenu(player);
        }
        return instance;
    }

    public void changeButtons() {
        ButtonsPanel.getInstance(player).getButton1().setIcon(new ImageIcon(ImageManager.getInstance().getImage("golpe")));
        ButtonsPanel.getInstance(player).getButton2().setIcon(new ImageIcon(ImageManager.getInstance().getImage("artilleria")));
        ButtonsPanel.getInstance(player).getButton3().setIcon(new ImageIcon(ImageManager.getInstance().getImage("regresar")));
        golpe();
        artilleria();
        regresar();
    }
    public void golpe(){
        ButtonsPanel.getInstance(player).getButton1().removeActionListener(ButtonsPanel.getInstance(player).getButton1().getActionListeners()[0]);
        ButtonsPanel.getInstance(player).getButton1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            ConsolePanel.getInstance().getConsole().append(player.getName()+" lanzo un golpe.\n");
            }
        });
    }
    public void artilleria(){
        ButtonsPanel.getInstance(player).getButton2().removeActionListener(ButtonsPanel.getInstance(player).getButton2().getActionListeners()[0]);
        ButtonsPanel.getInstance(player).getButton2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArtilleryMenu.getInstance().changeButtons();
            }
        });
    }
    public void regresar(){
        ButtonsPanel.getInstance(player).getButton3().removeActionListener(ButtonsPanel.getInstance(player).getButton3().getActionListeners()[0]);
        ButtonsPanel.getInstance(player).getButton3().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StartBattle.getInstance(player).changeButtons();
            }
        });
    }
}

