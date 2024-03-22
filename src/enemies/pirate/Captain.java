package enemies.pirate;

import enemies.Enemies;
import players.Player;

public class Captain extends Enemies {


    public Captain(String eName, int eHP, int eDm, int dropG, int giveExp) {
        super(eName, eHP, eDm, dropG, giveExp);
    }

    @Override
    public void eAttack(Player player) {
    }

    @Override
    public void dropItem(Player player) {

    }
}
