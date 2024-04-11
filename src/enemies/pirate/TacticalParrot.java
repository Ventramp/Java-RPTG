package enemies.pirate;

import enemies.Enemies;
import items.drops.Compass;
import items.drops.Jewells;
import items.drops.Wing;
import org.jetbrains.annotations.NotNull;
import players.Player;

import javax.swing.*;
import java.io.Serializable;

import static util.Randomized.rng;

public class TacticalParrot extends Enemies implements Serializable {
    public TacticalParrot() {
        super("Loro Tactico",5,0,5,5,5,5);
    }
    @Override
    public void dropItem(@NotNull Player player) {
        int prob = rng(1,100);
        player.getInventory().addItem(prob > 99 ? new Jewells() : new Wing());
    }
    @Override
    public void eAttack(Player player) {
        JOptionPane.showMessageDialog(null,name+"Ataca con Disparo doble");
        player.recibeDm(geteDm());
    }

    @Override
    public void displayData() {

    }
}
