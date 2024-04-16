package game;

import game.exeptions.InvalidOptionException;
import players.Player;
import util.managers.FileManager;
import util.interfaces.Interactive;

import javax.swing.*;
import java.io.File;

/**
 * La clase Game es la clase principal del juego. Es la clase que controla el flujo del juego y las interacciones entre
 * el jugador y los enemigos.
 */
public class Game {

    /**
     * El jugador del juego.
     */
    private Player player;
    private final int slot;
    /**
     * La lista de enemigos del juego.
     */


    /**
     * Constructor de la clase Game.
     */
    public Game(int slot) {

        this.slot = slot;
        player = null;
		/*enemies.add(new RookieGoblin());
		enemies.add(new AloneWolf());
		enemies.add(new RookieGoblin());
		enemies.add(new AloneWolf());
		enemies.add(new RookieGoblin());*/
        printMainMenu();
    }

    /**
     * Muestra el menú principal.
     */
    public void printMainMenu() {

        String menu = "1. Jugar\n2. Salir";
        try {
            int option = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (option) {
                case 1 -> {
                    try {
                        player = FileManager.loadGame(new File("files\\game" + slot + ".dat"));
                        Interactive.printDialog("¡Bienvenido de nuevo!");
                    } catch (Exception e) {
                        player = new Player(JOptionPane.showInputDialog("Ingresa el nombre del jugador:"));
                    }
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