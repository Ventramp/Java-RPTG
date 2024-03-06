package enemies.pirate;

import enemies.Enemies;
import Players.Player;
import org.jetbrains.annotations.NotNull;

import static util.Randomized.rng;
public class NavigatorPirate extends Enemies{
    public NavigatorPirate(){
        super ("Navegante",40,15,10,20);
    }
    @Override
    public void eAttack(Player player){
        switch (rng(0,2)){
            case -> eAttacking
    };

    }
    private void eAttacking (@NotNull Player player){
        System.out.printf("%s Ataco y te hizo %d Puntos de daño",geteName(),geteDm());
    }
}
