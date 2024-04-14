package game;
import enemies.Enemies;
import enemies.pirate.San;
import enemies.pirate.TacticalParrot;
import org.jetbrains.annotations.NotNull;
import players.Player;
import util.managers.FileManager;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import game.exeptions.InvalidOptionException;

import static util.Randomized.rng;

public class Game {

    private Player player;
    private final int slot;
    public final List<Enemies> enemiesl;
    public Game(int slot) {
        player = null;
        this.slot =slot;
        player = null;
        enemiesl = new ArrayList<>(5);
        enemiesl.add(new San());
        enemiesl.add(new San());
        enemiesl.add(new San());
        enemiesl.add(new TacticalParrot());
        enemiesl.add(new TacticalParrot());

    }
    public void mainMenu() {
        try {
            String [] opcion= {"Jugar", "Salir"};
            int seleccion=JOptionPane.showOptionDialog(null,"Pirate Quest","Game",0,JOptionPane.QUESTION_MESSAGE,null,opcion, "Jugar");
            switch (opcion[seleccion]) {

                case "Jugar" -> {
                    try {
                        player = FileManager.loadGame(new File("files\\game" + slot + ".dat"));
                        JOptionPane.showMessageDialog(null,"Bienvenido de Vuelta");
                    } catch (Exception e) {
                        player = new Player(JOptionPane.showInputDialog("Ingresa el nombre del jugador:"));
                        difficult();
                    }
                }
                case "Salir"->JOptionPane.showMessageDialog(null,"Gracias por jugar");
                default -> throw new InvalidOptionException();
            }
        } catch (Exception e) {
            mainMenu();
        }
    }
    public void difficult(){
        String [] opcion= {"Facil", "Normal","Dificil"};
        int sdifficult=JOptionPane.showOptionDialog(null,"Pirate Quest","Game",0,JOptionPane.QUESTION_MESSAGE,null,opcion, "Normal");
            switch (opcion[sdifficult]){
                case "Facil"-> player.setRevives(5);
                case "Normal"-> player.setRevives(3);
                case "Dificil"-> player.setRevives(0);
            }
    }




    public void equipArmor(){
        player.getInventory().equipArmorMenu(player);
    }
    public void equipWeapon(){
        player.getInventory().equipWeaponMenu(player);
    }
    public void gameOver(){
        JOptionPane.showMessageDialog(null,"Fin del Juego \n Regresando al menu principal");
        mainMenu();
    }
    private void revive(){

        if (player.getRevives() >0 ) {
            String[] opcion = {"Revivir", "Salir"};
            int sRevive = JOptionPane.showOptionDialog(null, "¿Quieres revivir?", "Revivir", 0, JOptionPane.QUESTION_MESSAGE, null, opcion, "Jugar");
            switch (opcion[sRevive]) {
                case "Revivir" -> {
                    player.revive();
                }

                case "Salir" -> mainMenu();
            }
        }else {
            JOptionPane.showMessageDialog(null, "No quedan Revivir");
            gameOver();
            }
        }
    public void endGame() {
        FileManager.saveGame(player, slot);
        JOptionPane.showMessageDialog(null,"Guardando Partida");
        mainMenu();
    }
    @NotNull
    private static Enemies getEnemy(List<Enemies> enemies) {

        Enemies enemy = enemies.get(rng(0, enemies.size() - 1));
        JOptionPane.showMessageDialog(null, enemy.getName()+" ha aparecido delante tuyo");
        return enemy;

    }

    }


