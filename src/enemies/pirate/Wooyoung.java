package enemies.pirate;

import enemies.Enemies;
import gui.panels.ConsolePanel;
import items.drops.Compass;
import items.drops.Jewells;
import org.jetbrains.annotations.NotNull;
import players.Player;
import util.annotations.RegularEnemy;

import javax.swing.*;

import static util.Randomized.rng;

@RegularEnemy
public class Wooyoung extends Enemies {
    public Wooyoung(Player player) {
        super("Wooyoung", 30, 0, 30,20, 5, 25,player);
        image = imageManager.getImage("wooyoung",
                new ImageIcon("img\\enemies\\Wooyoung.png").getImage());
    }
    @Override
    public void dropItem(Player player){
        int prob = rng(1,100);
        player.getInventory().addItem(prob > 99 ? new Jewells() : new Compass());
    }
    @Override
    public void eAttack(Player player)
    {
        switch (rng(0,3))
        {
            case 0 -> thrust(player);
            case 1 -> shot(player);
            case 2 -> robarG(player);
            case 3 -> thrust(player);
        }
    }
    //ataque tipo estoque con notnull para que no se pueda hacer sin player//
    private void thrust (@NotNull Player player){
        ConsolePanel.getInstance().getConsole().append(getName() + " Ataca con un Estoque\n");
        //llamada a la funcion con la cual los characters reciben daño//
        player.recibeDm(geteDm());
    }
    //ataque tipo disparo con posibilidad entre 1 y 3 disparos//
    public void shot (@NotNull Player player){
        ConsolePanel.getInstance().getConsole().append(getName()+" te va a disparar\n");
        int multshot = rng(0,3);
        for (int i=0; i<multshot;i++){
            ConsolePanel.getInstance().getConsole().append((i+1)+"° Disparo\n");
            player.recibeDm(geteDm());
        }
        ConsolePanel.getInstance().getConsole().append("Fin del ataque enemigo\n");
    }
    //el enemigo te roba tu dinero//
    public void robarG (@NotNull Player player){
        //si no tienes nada de dinero se burla
        if (player.getGold()==0){
            ConsolePanel.getInstance().getConsole().append(getName()+" te intenta robar los calzones\n");
        }
        //si tienes mas de 0 pero menos o igual a 10//
        if (player.getGold()<=10&player.getGold()>0){
            player.setGold(player.getGold() - 10);
            ConsolePanel.getInstance().getConsole().append(getName()+" Te robo el poco dinero que te quedaba\n");
        }
        if (player.getGold()>10) {
            //si es mayor a 10//
            player.setGold(player.getGold() - 10);
            ConsolePanel.getInstance().getConsole().append(getName() + " te robo 10 G\n");
        }
    }
}
