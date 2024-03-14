import players.Player;
import enemies.pirate.NavigatorPirate;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
       JOptionPane.showMessageDialog(null,"      ////////// BIENVENIDO //////////");
     //creacion de jugador//
        Player player= new Player("Player");
        NavigatorPirate navigator = new NavigatorPirate();
        player.accion(navigator);
        navigator.eAttack(player);
        player.accion(navigator);
        navigator.eAttack(player);
        player.accion(navigator);
        navigator.eAttack(player);
    }
}