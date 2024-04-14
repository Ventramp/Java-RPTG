package gui.events;

import enemies.Enemies;
import enemies.pirate.*;
import game.Game;
import gui.GeneralScreen;
import gui.panels.ButtonsPanel;
import org.jetbrains.annotations.NotNull;
import players.Player;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static util.Randomized.rng;

public class FigthLogic {
    private static FigthLogic instance;
    public Player player;
    public Enemies enemies;
    public GeneralScreen game;

    public FigthLogic(Player player, Enemies enemies, GeneralScreen game) {
        this.player = player;
        this.enemies = enemies;
        this.game = game;
    }

    public void fightCycle () {
        this.enemies=GeneralScreen.getInstance().getEnemies();
        if (!enemiesl.isEmpty()) {
            Enemies currentEnemy;
            currentEnemy = getEnemy(enemiesl);
            while (!currentEnemy.eDie() && !player.muerte()) {
            StartBattle.getInstance(player,enemies).changeButtons();
                if (currentEnemy.eDie()) {
                } else {
                    currentEnemy.eAttack(player);
                }
            }
            enemiesl.remove(currentEnemy);
        } else {
            JOptionPane.showMessageDialog(null, "Ya te has encontrado con todos\n los enemigos posibles de esta sesion");
        }
        ButtonsPanel.getInstance(player,enemies).changeButtons();
    }
    @NotNull
    private static Enemies getEnemy(List<Enemies> enemies) {

        Enemies enemy = enemies.get(rng(0, enemies.size() - 1));
        JOptionPane.showMessageDialog(null, enemy.getName()+" ha aparecido delante tuyo");
        return enemy;
    }
}
