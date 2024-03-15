import players.Player;
import enemies.pirate.NavigatorPirate;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "      ////////// BIENVENIDO //////////");
        //creacion de jugador//
        Player player = new Player("Player");
        NavigatorPirate n1 = new NavigatorPirate();
        while (!n1.eDie()) {
            player.accion(n1);
            if (n1.eDie()) {
            } else {
                n1.eAttack(player);
            }
        }
        NavigatorPirate n2 = new NavigatorPirate();
        while (!n2.eDie()||!player.muerte()) {
            player.accion(n2);
            if (n2.eDie()) {
            } else {
                n2.eAttack(player);
            }
        }
        NavigatorPirate n3 = new NavigatorPirate();
        while (!n3.eDie()) {
            player.accion(n3);
            if (n3.eDie()) {
            } else {
                n3.eAttack(player);
            }
        }
    }
}