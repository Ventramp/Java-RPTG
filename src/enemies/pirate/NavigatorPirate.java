package enemies.pirate;
import enemies.Enemies;
import players.Player;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

import java.io.Serializable;

import static util.Randomized.rng;
public class NavigatorPirate extends Enemies implements Serializable {
    public NavigatorPirate()
    {
        super ("Navegante",50,25,15,20);
    }
    //override de enemieattack con rng para que se hagan diferentes acciones//
    @Override
    public void eAttack(Player player)
    {
        switch (rng(0,2))
        {
            case 0 -> thrust(player);
            case 1 -> shot(player);
            case 2 -> robarG(player);
        }
    }
    //ataque tipo estoque con notnull para que no se pueda hacer sin player//
    private void thrust (@NotNull Player player){
        JOptionPane.showMessageDialog(null,geteName()+" Ataca con un Estoque");
        //llamada a la funcion con la cual los characters reciben daño//
        player.recibeDm(geteDm());
    }
    //ataque tipo disparo con posibilidad entre 1 y 3 disparos//
    public void shot (@NotNull Player player){
        JOptionPane.showMessageDialog(null,geteName()+" te va a disparar");
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
            JOptionPane.showMessageDialog(null,geteName()+" te intenta robar los calzones");
        }
        //si tienes mas de 0 pero menos o igual a 10//
        if (player.getGold()<=10&player.getGold()>0){
            player.setGold(player.getGold() - 10);
            JOptionPane.showMessageDialog(null,geteName()+" Te robo el poco dinero que te quedaba");
        }
        if (player.getGold()>10) {
            //si es mayor a 10//
            player.setGold(player.getGold() - 10);
            JOptionPane.showMessageDialog(null,geteName() + " te robo 10 G");
        }
    }
}
