package enemies.pirate;
import players.Player;
import enemies.Enemies;

public class Ateez extends Enemies {


    public Ateez() {

        super("ATEZZ", 200, 60, 2000, 500);
    }
    @Override
    public void eAttack(Player player) {
    }

    @Override
    public void dropItem(Player player) {

    }
}
