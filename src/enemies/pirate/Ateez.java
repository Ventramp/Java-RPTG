package enemies.pirate;
import players.Player;
import enemies.Enemies;

public class Ateez extends Enemies {


    public Ateez(String eName, int eHP, int eDm, int dropG, int giveExp) {
        super(eName, eHP, eDm, dropG, giveExp);
    }
    @Override
    public void eAttack(Player player) {
    }

    @Override
    public void dropItem(Player player) {

    }
}
