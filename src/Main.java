import players.Player;
import enemies.pirate.NavigatorPirate;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n////////// BIENVENIDO //////////");
     //creacion de jugador//
        Player player= new Player("Player");
        NavigatorPirate navigator = new NavigatorPirate();
     player.displayData();
     player.aboutJob();
     player.attack(navigator);
     player.magicA(navigator);
     player.levelUp();
     player.displayData();
    navigator.eAttack(player);
        navigator.eAttack(player);
        navigator.eAttack(player);
        navigator.eAttack(player);
    player.displayData();

    }
}