package game;
import enemies.Enemies;
import enemies.pirate.NavigatorPirate;
import enemies.pirate.ViceCaptain;
import enemies.pirate.TacticalParrot;
import enemies.pirate.Captain;
import enemies.pirate.Ateez;
import players.Player;
import util.FileManager;
import util.Randomized;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private Player player;
    private final List<Enemies> enemies;
    public Game() {
        player = null;
        enemies = new ArrayList<>(5);
        enemies.add(new NavigatorPirate());
        enemies.add(new TacticalParrot());
        enemies.add(new ViceCaptain());
        enemies.add(new Ateez());
        enemies.add(new Captain());
    }
    public void printMainMenu() {

        String menu = "1. Jugar\n2. Salir";
        try {
            int option = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (option) {

                case 1 -> {
                    try {
                        player = FileManager.loadGame();
                        String Bienvenida JOptionPazne.showOptionDialog(null,"Bienvenido");
                    } catch (Exception e) {
                        player = new Player(JOptionPane.showInputDialog("Ingresa el nombre del jugador:"));
                    }
                    printPlayerMenu();
                }
                case 2 -> Interactive.printDialog("Gracias por jugar");
                default -> throw new InvalidOptionException();
            }
        } catch (Exception e) {
            Interactive.printDialog("La opción ingresada no es válida");
            printMainMenu();
        }
    }

}
