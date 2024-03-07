package enemies.pirate;

import enemies.Enemies;
import players.Player;
import org.jetbrains.annotations.NotNull;

import static util.Randomized.rng;
public class NavigatorPirate extends Enemies{
    public NavigatorPirate(){
        super ("Navegante",40,10,10,20);
    }
    @Override
    public void eAttack(Player player){
        switch (rng(0,2)){
            case 0 -> thrust(player);
            case 1 -> shot(player);
            case 2 -> robarG(player);
    }

    }
    private void thrust (@NotNull Player player){
        System.out.printf("%s Ataco y te hizo %d Puntos de daño\n\n",geteName(),geteDm());
        player.recibeDm(geteDm());
    }
    public void shot (@NotNull Player player){
        System.out.println(geteName()+" te va a disparar");
        int multshot = rng(0,2);
        for (int i=0; i<multshot;i++){

            System.out.println((i+1)+"° Disparo\n"+geteDm());
            player.recibeDm(geteDm());
        }
        System.out.printf("%s hizo un total de %d de daño\n\n",geteName(),(geteDm()*multshot));
    }
    /*Dudas: que pasa si el oro acual es igual a 0?*/
    public void robarG (@NotNull Player player){
        System.out.println(geteName()+" te robo 10 G\n");
        player.setGold(player.getGold()-10);
    }
}
