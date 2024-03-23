package enemies.pirate;

import enemies.Enemies;
import items.drops.Jewells;
import items.drops.PirateFlag;
import items.drops.PirateHat;
import players.Player;

import static util.Randomized.rng;

public class ViceCaptain extends Enemies {


    public ViceCaptain() {
        super("Vice Capitan",80 , 40, 800, 200);
    }

    @Override
    public void eAttack(Player player) {
    }

    @Override
    public void dropItem(Player player) {
        int prob = rng(1,100);
        player.getInventory().addItem(prob > 99 ? new Jewells() : new PirateHat());
    }
}
