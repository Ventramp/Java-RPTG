package enemies.pirate;

import enemies.Enemies;
import items.drops.Compass;
import items.drops.Jewells;
import items.drops.Wing;
import org.jetbrains.annotations.NotNull;
import players.Player;

import java.io.Serializable;

import static util.Randomized.rng;

public class TacticalParrot extends Enemies implements Serializable {
    public TacticalParrot() {
        super("Perico Armado",30, 50, 10, 50);
    }
    @Override
    public void dropItem(@NotNull Player player) {
        int prob = rng(1,100);
        player.getInventory().addItem(prob > 90 ? new Jewells() : new Wing());
    }
    @Override
    public void eAttack(Player player) {
    }
}
