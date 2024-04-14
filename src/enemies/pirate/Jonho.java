package enemies.pirate;

import enemies.Enemies;
import players.Player;

import javax.swing.*;

public class Jonho extends Enemies {

    public Jonho() {
        super("Jonho",5,0,5,5,5,5);
        image = imageManager.getImage("tinyBat",
                new ImageIcon("img\\enemies\\Jonho.png").getImage());
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
