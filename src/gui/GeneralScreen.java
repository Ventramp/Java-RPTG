package gui;

import enemies.pirate.*;
import game.Game;
import gui.events.StartBattle;
import gui.panels.*;
import gui.panels.StatsPanel;
import org.jetbrains.annotations.NotNull;
import players.Player;
import enemies.Enemies;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static util.Randomized.rng;

public class GeneralScreen extends JFrame {
    private static GeneralScreen instance;
    private JPanel rScreen;
    private JPanel buttonsPanel;
    private JPanel enemyPanel;
    private JPanel consolePanel;
    private JTabbedPane playerTabbed;
    private Player player;
    private Enemies enemies;

    public static void main(String[] args) {
        GeneralScreen.getInstance().startGame();
    }

    public static GeneralScreen getInstance() {
        if (instance == null) {
            instance = new GeneralScreen();
        }
        return instance;
    }

    public GeneralScreen() {
        setTitle("PirATEEZ Quest");
        setLocationRelativeTo(null);
        setContentPane(rScreen);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void startGame() {
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Enemies getEnemies() {
        return enemies;
    }

    public void setEnemies(Enemies enemies) {
        this.enemies = enemies;
    }

    private void createUIComponents() {
        player = SelectFileWindow.getInstance().getPlayer();
        String message = String.format("¡Bienvenido a la aventura, %s!\n", player.getName());
        ConsolePanel.getInstance().getConsole().append(message);
        enemies = new HongjoongC(player);
        enemyPanel = EnemyPanel.getInstance(enemies);
        consolePanel = ConsolePanel.getInstance();
        buttonsPanel = ButtonsPanel.getInstance(player, enemies);
        playerTabbed = PlayerPanel.getInstance();
        StatusPanel.getInstance(player, PlayerPanel.getInstance(), 0);
        StatsPanel.getInstance(player, PlayerPanel.getInstance(), 1);
    }
}
