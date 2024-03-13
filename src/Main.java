import players.Player;
import enemies.pirate.NavigatorPirate;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n////////// BIENVENIDO //////////");
     //creacion de jugador//
        Player player= new Player("Player");
        NavigatorPirate navigator = new NavigatorPirate();
        player.selectAttack(navigator);
        navigator.eAttack(player);
        player.selectAttack(navigator);
        navigator.eAttack(player);
        player.selectAttack(navigator);
        navigator.eAttack(player);
        player.displayData();
    player.displayData();
    }
}