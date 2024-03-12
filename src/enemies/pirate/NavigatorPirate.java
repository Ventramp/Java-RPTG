package enemies.pirate;
import enemies.Enemies;
import players.Player;
import org.jetbrains.annotations.NotNull;
import static util.Randomized.rng;
public class NavigatorPirate extends Enemies{
    public NavigatorPirate()
    {
        super ("Navegante",40,40,10,10,110);
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
        System.out.printf("%s Ataco y te hizo %d Puntos de daño\n\n",geteName(),geteDm());
        //llamada a la funcion con la cual los characters reciben daño//
        player.recibeDm(geteDm());
    }
    //ataque tipo disparo con posibilidad entre 1 y 3 disparos//
    public void shot (@NotNull Player player){
        System.out.println(geteName()+" te va a disparar");
        int multshot = rng(1,3);
        for (int i=1; i==multshot;i++){
            System.out.println((i)+"° Disparo\n"+geteDm());
            player.recibeDm(geteDm());
        }
        System.out.printf("%s hizo un total de %d de daño\n\n",geteName(),(geteDm()*(multshot-1)));
    }
    //el enemigo te roba tu dinero//
    public void robarG (@NotNull Player player){
        //si no tienes nada de dinero se burla
        if (player.getGold()==0){
            System.out.printf("%s se burla de ti puesto que no tienes dinero que pueda robar\n\n",geteName());
        }
        //si tienes mas de 0 pero menos o igual a 10//
        if (player.getGold()<=10&player.getGold()>0){
            player.setGold(player.getGold() - 10);
            System.out.printf("%s Te robo el poco dinero que te quedaba\n\n",geteName());
        }
        if (player.getGold()>10) {
            //si es mayor a 10//
            player.setGold(player.getGold() - 10);
            System.out.println(geteName() + " te robo 10 G\n");
        }
    }
}
