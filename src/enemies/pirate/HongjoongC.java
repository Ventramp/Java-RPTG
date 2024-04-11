package enemies.pirate;

import enemies.Enemies;
import items.drops.Jewells;
import items.drops.PirateFlag;
import players.Player;

import static util.Randomized.rng;

public class HongjoongC extends Enemies {


    public HongjoongC() {
        super("Captain HongJoo",5,0,5,5,5,5);
    }

    @Override
    public void eAttack(Player player) {
    }

    @Override
    public void dropItem(Player player) {
        int prob = rng(1,100);
        player.getInventory().addItem(prob > 99 ? new Jewells() : new PirateFlag());
    }

    @Override
    public void displayData() {

    }
}
