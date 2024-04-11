package gui.dataLabels;

import characters.BasicCharacter;
import enemies.Enemies;
import players.Player;
import util.managers.FontManager;

import javax.swing.*;
import java.awt.*;

public class HpLabel extends JLabel {

    private BasicCharacter character;
    private String text;
    public HpLabel(Player character) {

        this.character = character;
        init();
        Font font = FontManager.getInstance().getFont("Player");

        setFont(font);
    }

    public HpLabel(Enemies enemies) {

        this.character = enemies;
        init();
        Font font = FontManager.getInstance().getFont("Player");
        setFont(font);
    }

    private void init() {


        text = String.format("%d/%d", character.getHp(), character.getMaxHp());
        double hpPercentage = (double) character.getHp() / character.getMaxHp();
    }

    public void updateCharacter(BasicCharacter character) {

        this.character = character;
        init();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        BasicStroke contorno = new BasicStroke(5.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
        g2d.setStroke(contorno);
        g2d.drawString(text, 0, 0);
    }
}
