package game;
import enemies.Enemies;
import enemies.pirate.NavigatorPirate;
import enemies.pirate.ViceCaptain;
import enemies.pirate.TacticalParrot;
import enemies.pirate.Captain;
import enemies.pirate.Ateez;
import org.jetbrains.annotations.NotNull;
import players.Player;
import util.FileManager;
import util.Randomized;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import game.exeptions.InvalidOptionException;

import static util.Randomized.rng;

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
    public void mainMenu() {
        try {
            String [] opcion= {"Jugar", "Salir"};
            int seleccion=JOptionPane.showOptionDialog(null,"Pirate Quest","Game",0,JOptionPane.QUESTION_MESSAGE,null,opcion, "Jugar");
            switch (opcion[seleccion]) {

                case "Jugar" -> {
                    try {
                        player = FileManager.loadGame();
                        JOptionPane.showMessageDialog(null,"Bienvenido de Vuelta");
                    } catch (Exception e) {
                        player = new Player(JOptionPane.showInputDialog("Ingresa el nombre del jugador:"));
                    }
                    actionMenu();
                }
                case "Salir"->JOptionPane.showMessageDialog(null,"Gracias por jugar");
                default -> throw new InvalidOptionException();
            }
        } catch (Exception e) {
            mainMenu();
        }
    }
    public void actionMenu(){
        try {
            String [] opcion= {"Pelear", "Stats","Inventario","MENU"};
            int sAccion=JOptionPane.showOptionDialog(null,"Menu de Acciones","Accion",0,JOptionPane.QUESTION_MESSAGE,null,opcion, "Stats");

            switch (opcion[sAccion]) {

                case "Pelea" -> fightCycle();
                case "Stats" -> player.displayData();   actionMenu();
                case "MENU" -> endGame();
                case "Inventario"->
                default -> throw new InvalidOptionException();
                actionMenu();
            }
        } catch (Exception e) {
            actionMenu();
        }
    }
    public void inventoryMenu(){
        player.getInventory().printItems();
        String [] opcion= {"Equipar Armadura", "Equipar Arma","Regresar"};
        int sInventory=JOptionPane.showOptionDialog(null,"Menu de Inventario","Inventario",0,JOptionPane.QUESTION_MESSAGE,null,opcion, "Regresar");
        switch (opcion[sInventory]){
            case "Equipar Armadura"-> ;
            case "Equipar Arma" -> ;
            case "Regresar" -> actionMenu();
        }
    }
    public void fightCycle (){
        Enemies currentEnemy;
        currentEnemy = getEnemy(enemies);
        while (!currentEnemy.eDie() && !player.muerte()) {
            player.accion(currentEnemy);
            if (currentEnemy.eDie()) {
            } else {
                currentEnemy.eAttack(player);
            }
        }
    }
    @NotNull
    private static Enemies getEnemy(List<Enemies> enemies) {

        Enemies enemy = enemies.get(rng(0, enemies.size() - 1));
        return enemy;
    }
    }


