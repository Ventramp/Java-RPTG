package game;
import enemies.Enemies;
import enemies.pirate.*;
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
    public Game(int slot) {
        player = null;
        this.slot =slot;
        player = null;
    }

    public void equipArmor(){
        player.getInventory().equipArmorMenu(player);
    }
    public void equipWeapon(){
        player.getInventory().equipWeaponMenu(player);
    }
    public void gameOver(){
        JOptionPane.showMessageDialog(null,"Fin del Juego \n Regresando al menu principal");
    }

    public void endGame() {
        FileManager.saveGame(player, slot);
        JOptionPane.showMessageDialog(null,"Guardando Partida");
    }
    @NotNull
    private static Enemies getEnemy(List<Enemies> enemies) {

        Enemies enemy = enemies.get(rng(0, enemies.size() - 1));
        JOptionPane.showMessageDialog(null, enemy.getName()+" ha aparecido delante tuyo");
        return enemy;
    }

}


