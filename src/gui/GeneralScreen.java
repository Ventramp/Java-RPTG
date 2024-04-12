package gui;
import enemies.pirate.San;
import gui.panels.*;
import gui.panels.StatsPanel;
import players.Player;
import enemies.Enemies;


import javax.swing.*;

public class GeneralScreen extends JFrame{
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
    public void startGame(){
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void createUIComponents() {
        player = new Player("Ventramp");
        enemies = new San();
        String message = String.format("¡Bienvenido a la aventura, %s!\n", player.getName());
        ConsolePanel.getInstance().getConsole().append(message);
        enemyPanel = EnemyPanel.getInstance(enemies);
        consolePanel = ConsolePanel.getInstance();
        buttonsPanel = ButtonsPanel.getInstance();
        playerTabbed = PlayerPanel.getInstance();
        StatusPanel.getInstance(player,PlayerPanel.getInstance(),0);
        StatsPanel.getInstance(player,PlayerPanel.getInstance(),1);
    }
}
