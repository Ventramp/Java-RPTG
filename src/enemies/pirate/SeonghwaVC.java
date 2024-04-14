package enemies.pirate;

import enemies.Enemies;
import items.drops.Jewells;
import items.drops.PirateHat;
import players.Player;

import javax.swing.*;

import static util.Randomized.rng;

public class SeonghwaVC extends Enemies {


    public SeonghwaVC() {
        super("Vicecapitan Seonghwa",5,0,5,5,5,5);
        image = imageManager.getImage("tinyBat",
                new ImageIcon("img\\enemies\\Seonghwa.png").getImage());
    }

    @Override
    public void eAttack(Player player) {
    }

    @Override
    public void dropItem(Player player) {
        int prob = rng(1,100);
        player.getInventory().addItem(prob > 99 ? new Jewells() : new PirateHat());
    }

    @Override
    public void displayData() {

    }
}
