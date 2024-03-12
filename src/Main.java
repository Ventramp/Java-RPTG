import players.Player;
import enemies.pirate.NavigatorPirate;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n////////// BIENVENIDO //////////");
     //creacion de jugador//
        Player player= new Player("Player");
        NavigatorPirate navigator = new NavigatorPirate();

        navigator.eAttack(player);
        navigator.eAttack(player);
        navigator.eAttack(player);
        player.displayData();
        player.attack(navigator);
        player.magicA(navigator);
        player.attack(navigator);
        player.magicA(navigator);
        player.attack(navigator);
        player.magicA(navigator);
    player.displayData();
    }
}