package enemies.pirate;

import enemies.Enemies;
import items.drops.Jewells;
import items.drops.PirateHat;
import players.Player;

import static util.Randomized.rng;

public class SeonghwaVC extends Enemies {


    public SeonghwaVC() {
        super("Vice Capitan Seonghwa",80 , 40, 800, 200);
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
