package gui.dataLabels;

import characters.BasicCharacter;
import enemies.Enemies;
import players.Player;
import util.managers.FontManager;
import util.managers.ImageManager;

import javax.swing.*;
import java.awt.*;

public class EnemyHpLabel extends JLabel {

    private BasicCharacter character;
    private Image image;
    private String text;


    public EnemyHpLabel(Enemies enemy) {

        this.character = enemy;
        init();
        Font font = FontManager.getInstance().getFont("Player");
        Dimension size = new Dimension(image.getWidth(null), image.getHeight(null) + 10);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        setFont(font);
    }

    private void init() {

        ImageManager imageManager = ImageManager.getInstance();
        text = String.format("%d/%d", character.getHp(), character.getMaxHp());
        Color color;
        image = imageManager.getImage("hpEnemy");
        color = new Color(0, 0, 0, 255);
        setForeground(color);
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
        g2d.drawImage(image, 0, 10, null);
        int textPositionY = image.getHeight(null) / 2 + 10 + g2d.getFontMetrics().getHeight() / 4;
        int textPositionX = ((image.getWidth(null) - 28) / 2) + 28 - (g2d.getFontMetrics().stringWidth(text) / 2);
        g2d.translate(textPositionX, textPositionY);
        BasicStroke contorno = new BasicStroke(5.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
        g2d.setStroke(contorno);
        g2d.drawString(text, 0, 0);
    }
}
