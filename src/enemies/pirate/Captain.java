package enemies.pirate;

import enemies.Enemies;
import items.drops.Compass;
import items.drops.Jewells;
import items.drops.PirateFlag;
import players.Player;

import static util.Randomized.rng;

public class Captain extends Enemies {


    public Captain() {
        super("Capitan",100, 50, 1000, 250);
    }

    @Override
    public void eAttack(Player player) {
    }

    @Override
    public void dropItem(Player player) {
        int prob = rng(1,100);
        player.getInventory().addItem(prob > 99 ? new Jewells() : new PirateFlag());
    }
}
