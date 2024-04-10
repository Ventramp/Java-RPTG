package graphInterface.panels;

import enemies.Enemies;

import javax.swing.*;
import java.awt.*;

public class EnemyPanel extends JPanel {
    private static EnemyPanel instance;
    private JPanel rEnemy;

    public EnemyPanel(){

    }
    public static EnemyPanel getInstance() {

        if (instance == null) {

            instance = new EnemyPanel();
        }
        return instance;
    }
}
