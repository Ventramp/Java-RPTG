package gui;
import enemies.pirate.*;
import gui.events.StartBattle;
import gui.panels.*;
import gui.panels.StatsPanel;
import org.jetbrains.annotations.NotNull;
import players.Player;
import enemies.Enemies;


import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static util.Randomized.rng;

public class GeneralScreen extends JFrame{
    private static GeneralScreen instance;
    private JPanel rScreen;
    private JPanel buttonsPanel;
    private JPanel enemyPanel;
    private JPanel consolePanel;
    private JTabbedPane playerTabbed;
    private Player player;
    private Enemies enemies;
    public final List<Enemies> enemiesl;

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
        enemiesl = new ArrayList<>(9);
        enemiesl.add(new HongjoongC());
        enemiesl.add(new Jonho());
        enemiesl.add(new Mingi());
        enemiesl.add(new San());
        enemiesl.add(new SeonghwaVC());
        enemiesl.add(new Wooyoung());
        enemiesl.add(new Yeosang());
        enemiesl.add(new Yunho());
        setTitle("PirATEEZ Quest");
        setLocationRelativeTo(null);
        setContentPane(rScreen);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public void startGame(){
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
    @NotNull
    private static Enemies getEnemy(List<Enemies> enemies) {

        Enemies enemy = enemies.get(rng(0, enemies.size() - 1));
        ConsolePanel.getInstance().getConsole().append(enemy.getName()+" ha aparecido delante tuyo\n");
        return enemy;
    }
    private void createUIComponents() {
        enemies=new HongjoongC();
        player = new Player("Ventramp");
        String message = String.format("¡Bienvenido a la aventura, %s!\n", player.getName());
        ConsolePanel.getInstance().getConsole().append(message);
        enemyPanel = EnemyPanel.getInstance(enemies);
        consolePanel = ConsolePanel.getInstance();
        buttonsPanel = ButtonsPanel.getInstance(player, enemies);
        playerTabbed = PlayerPanel.getInstance();
        StatusPanel.getInstance(player,PlayerPanel.getInstance(),0);
        StatsPanel.getInstance(player,PlayerPanel.getInstance(),1);
    }
    public void initializeBattle() {
        Enemies enemy = getEnemy(enemiesl);
        StartBattle.getInstance(player, enemies).changeButtons();
    }
    public void battleend() {
        ButtonsPanel.getInstance(player, null).changeButtons();
        enemyPanel = null;
    }
}
