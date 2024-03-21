package enemies.pirate;

import enemies.Enemies;
import players.Player;

public class TacticalParrot extends Enemies {


    public TacticalParrot(String eName, int eHP, int eDm, int dropG, int giveExp) {
        super(eName, eHP, eDm, dropG, giveExp);
    }

    @Override
    public void eAttack(Player player) {
    }
}
