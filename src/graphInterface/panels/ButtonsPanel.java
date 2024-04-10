package graphInterface.panels;

import enemies.Enemies;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import game.Game;
import players.Player;

public class ButtonsPanel extends JPanel{
    private static ButtonsPanel instance;
    private JPanel rButtons;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private Enemies enemies;
    private Player player;

    public ButtonsPanel() {
       //public void waiting(){
         //   button1.setName("Pelear");
           // button2.setName("Inventario");
            //button3.setName("Salir");

        //public void fighting(){
          //  button1.setName("Golpe");
            //button2.setName("Artilleria");
            //button3.setName("Huir");
        setVisible(true);


        //button1.addActionListener(new ActionListener() {
          //  @Override
           // public void actionPerformed(ActionEvent e) {
            //    game.fightCycle();
            //}
        //});
        //button2.addActionListener(new ActionListener() {
          //  @Override
           // public void actionPerformed(ActionEvent e) {
             //   game.inventoryMenu();
            //}
        //});
        //button3.addActionListener(new ActionListener() {
          //  @Override
            //public void actionPerformed(ActionEvent e) {
              //  game.endGame();
            //}
        //});
    }

    public static ButtonsPanel getInstance() {

        if (instance == null) {

            instance = new ButtonsPanel();
        }
        return instance;
    }

}
