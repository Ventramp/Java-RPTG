package enemies.pirate;

import enemies.Enemies;
import players.Player;

import javax.swing.*;

public class Yunho extends Enemies {

    public Yunho() {
        super("Yunho",5,0,5,5,5,5);
        image = imageManager.getImage("tinyBat",
                new ImageIcon("img\\enemies\\Yunho.png").getImage());
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
