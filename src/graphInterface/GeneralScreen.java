package graphInterface;
import graphInterface.panels.*;
import graphInterface.panels.StatsPanel;

import javax.swing.*;

public class GeneralScreen extends JFrame{
    private static GeneralScreen instance;
    private JPanel rScreen;
    private JPanel viewPanel;
    private JPanel buttonsPanel;
    private JPanel enemyPanel;
    private JPanel consolePanel;
    private JPanel statsPanel;

    public static GeneralScreen getInstance() {

        if (instance == null) {

            instance = new GeneralScreen();
        }
        return instance;
    }
    public GeneralScreen() {

        setVisible(true);
        setTitle("PirATEEZ Quest");
        setLocationRelativeTo(null);
        setSize(1280,800);
        setContentPane(rScreen);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void createUIComponents() {
        buttonsPanel = ButtonsPanel.getInstance();
        enemyPanel = EnemyPanel.getInstance();
        consolePanel= ConsolePanel.getInstance();
        statsPanel = StatsPanel.getInstance();
    }
}
