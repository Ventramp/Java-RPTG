package enemies.pirate;
import enemies.Enemies;
import items.drops.Compass;
import items.drops.Jewells;
import players.Player;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

import java.io.Serializable;

import static util.Randomized.rng;
public class San extends Enemies implements Serializable {
    public San() {
        super("San",5,0,5,5,5,5);
        image = imageManager.getImage("tinyBat",
                new ImageIcon("img\\enemies\\San.png").getImage());
    }

    //override de enemieattack con rng para que se hagan diferentes acciones//
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
        JOptionPane.showMessageDialog(null,getName()+" Ataca con un Estoque");
        //llamada a la funcion con la cual los characters reciben daño//
        player.recibeDm(geteDm());
    }
    //ataque tipo disparo con posibilidad entre 1 y 3 disparos//
    public void shot (@NotNull Player player){
        JOptionPane.showMessageDialog(null,getName()+" te va a disparar");
        int multshot = rng(0,3);
        for (int i=0; i<multshot;i++){
            JOptionPane.showMessageDialog(null,(i+1)+"° Disparo");
            player.recibeDm(geteDm());
        }
        JOptionPane.showMessageDialog(null,"Fin del ataque enemigo");
    }
    //el enemigo te roba tu dinero//
    public void robarG (@NotNull Player player){
        //si no tienes nada de dinero se burla
        if (player.getGold()==0){
            JOptionPane.showMessageDialog(null,getName()+" te intenta robar los calzones");
        }
        //si tienes mas de 0 pero menos o igual a 10//
        if (player.getGold()<=10&player.getGold()>0){
            player.setGold(player.getGold() - 10);
            JOptionPane.showMessageDialog(null,getName()+" Te robo el poco dinero que te quedaba");
        }
        if (player.getGold()>10) {
            //si es mayor a 10//
            player.setGold(player.getGold() - 10);
            JOptionPane.showMessageDialog(null,getName() + " te robo 10 G");
        }
    }

    @Override
    public void displayData() {

    }
}
