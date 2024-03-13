package enemies.pirate;
import enemies.Enemies;
import players.Player;
import org.jetbrains.annotations.NotNull;
import static util.Randomized.rng;
public class NavigatorPirate extends Enemies{
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
        System.out.printf("%s Ataca con un Estoque\n\n",geteName());
        //llamada a la funcion con la cual los characters reciben daño//
        player.recibeDm(geteDm());
    }
    //ataque tipo disparo con posibilidad entre 1 y 3 disparos//
    public void shot (@NotNull Player player){
        System.out.println(geteName()+" te va a disparar\n");
        int multshot = rng(0,3);
        for (int i=0; i<multshot;i++){
            System.out.println((i+1)+"° Disparo\n");
            player.recibeDm(geteDm());
        }
        System.out.println("Fin del ataque");
    }
    //el enemigo te roba tu dinero//
    public void robarG (@NotNull Player player){
        //si no tienes nada de dinero se burla
        if (player.getGold()==0){
            System.out.printf("%s te intenta robar los calzones\n\n",geteName());
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
