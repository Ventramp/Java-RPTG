package enemies.pirate;

import enemies.Enemies;
import players.Player;

import javax.swing.*;

public class Mingi extends Enemies {
    public Mingi() {
        super("Mingi",5,0,5,5,5,5);
        image = imageManager.getImage("tinyBat",
                new ImageIcon("img\\enemies\\Mingi.png").getImage());
    }

    @Override
    public void eAttack(Player player) {

    }

    @Override
    public void dropItem(Player player) {

    }

    @Override
    public void displayData() {

    }
}
