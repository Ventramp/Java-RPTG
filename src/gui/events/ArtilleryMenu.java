package gui.events;

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
    public static ArtilleryMenu getInstance() {

        if (instance == null) {

            instance = new ArtilleryMenu();
        }
        return instance;
    }
    public void changeButtons(){
        ButtonsPanel.getInstance(player).getButton1().setIcon(new ImageIcon(ImageManager.getInstance().getImage("aNormal")));
        ButtonsPanel.getInstance(player).getButton2().setIcon(new ImageIcon(ImageManager.getInstance().getImage("aCargado")));
        ButtonsPanel.getInstance(player).getButton3().setIcon(new ImageIcon(ImageManager.getInstance().getImage("regresar")));
        normal();
        cargado();
        regresar();
    }
    public void normal(){
        ButtonsPanel.getInstance(player).getButton1().removeActionListener(ButtonsPanel.getInstance(player).getButton1().getActionListeners()[0]);
        ButtonsPanel.getInstance(player).getButton1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    public void cargado(){
        ButtonsPanel.getInstance(player).getButton2().removeActionListener(ButtonsPanel.getInstance(player).getButton2().getActionListeners()[0]);
        ButtonsPanel.getInstance(player).getButton2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConsolePanel.getInstance().getConsole().append(player.getName()+" uso Libra.\n");
            }
        });
    }
    public void regresar(){
        ButtonsPanel.getInstance(player).getButton3().removeActionListener(ButtonsPanel.getInstance(player).getButton3().getActionListeners()[0]);
        ButtonsPanel.getInstance(player).getButton3().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AttackMenu.getInstance(player).changeButtons();
            }
        });
    }
}
