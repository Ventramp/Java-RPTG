package gui.dataLabels;

import characters.BasicCharacter;
import players.Player;
import util.managers.FontManager;

import javax.swing.*;
import java.awt.*;

public class ApLabel extends JLabel {

    private static ApLabel instance;
    private BasicCharacter character;
    private String text;

    public static ApLabel getInstance(Player character) {

        if (instance == null) {

            instance = new ApLabel(character);
        }
        return instance;
    }

    private ApLabel(Player player) {

        this.character = player;
        init(player);
        Font font = FontManager.getInstance().getFont("Player");
        setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        setFont(font);
    }

    private void init(Player player) {

        text = String.format("%d/%d", player.getAp(), player.getMaxAp());
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

    public void updateCharacter(BasicCharacter character) {

        this.character = character;
        init((Player) this.character);
        repaint();
    }
}