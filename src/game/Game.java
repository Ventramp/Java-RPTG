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
        enemies.add(new Ateez());

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
                        difficult();
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
    public void difficult(){
        String [] opcion= {"Facil", "Dificil","Infierno"};
        int sDificult=JOptionPane.showOptionDialog(null,"Selecciona la dificultad\n La dificultad se define por el numero de vidas","Dificultad",0,JOptionPane.QUESTION_MESSAGE,null,opcion, "Facil");
        switch (opcion[sDificult]){
            case "Facil"-> player.setRevives(5);
            case "Dificil" -> player.setRevives(3);
            case "Infierno" -> player.setRevives(0);
        }
    }
    public void actionMenu(){

            String [] opcion= {"Pelear", "Stats","Inventario","MENU"};
            int sAccion=JOptionPane.showOptionDialog(null,"Menu de Acciones","Accion",0,JOptionPane.QUESTION_MESSAGE,null,opcion, "Stats");

            switch (opcion[sAccion]) {
                case "Pelear" -> fightCycle();
                case "Stats" -> {player.displayData();   actionMenu();}
                case "MENU" -> endGame();
                case "Inventario"-> inventoryMenu();
            }
    }
    public void inventoryMenu(){
        player.getInventory().printItems();
        String [] opcion= {"Equipar Armadura", "Equipar Arma","Regresar"};
        int sInventory=JOptionPane.showOptionDialog(null,"Menu de Inventario","Inventario",0,JOptionPane.QUESTION_MESSAGE,null,opcion, "Regresar");
        switch (opcion[sInventory]){
            case "Equipar Armadura"-> equipArmor();
            case "Equipar Arma" -> equipWeapon();
            case "Regresar" -> actionMenu();
        }
    }
    public void fightCycle (){

        if(!enemies.isEmpty()) {
            Enemies currentEnemy;
            currentEnemy = getEnemy(enemies);
            while (!currentEnemy.eDie() && !player.muerte()) {
                figthLogic(currentEnemy);
            }
            enemies.remove(currentEnemy);
            if (player.muerte()){
                player.revive();
            }
            if (gameOver(player)){
                JOptionPane.showMessageDialog(null,"Has muerto\nTe has quedado sin vidas\nRegresando al Menu principal");
                mainMenu();
            }
        }
        else {
            JOptionPane.showMessageDialog(null,"No quedan Enemigos");
        actionMenu();}
    }
    public void figthLogic(Enemies enemies){
        player.accion(enemies);
        if (enemies.eDie()) {
        } else {
            enemies.eAttack(player);
        }
    }
    public void equipArmor(){
        player.getInventory().equipArmorMenu(player);
        actionMenu();
    }
    public void equipWeapon(){
        player.getInventory().equipWeaponMenu(player);
        actionMenu();
    }
    private void endGame() {

        JOptionPane.showMessageDialog(null,"Gracias por jugar");
        FileManager.saveGame(player);
    }
    private boolean gameOver(Player player){
        return player.getRevives() < 0;
    }

    @NotNull
    private static Enemies getEnemy(List<Enemies> enemies) {

        Enemies enemy = enemies.get(rng(0, enemies.size() - 1));
        JOptionPane.showMessageDialog(null, enemy.geteName()+" ha aparecido delante tuyo");
        return enemy;

    }

    }


