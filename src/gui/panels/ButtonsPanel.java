package gui.panels;

import enemies.Enemies;

import javax.swing.*;

import players.Player;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import util.managers.ImageManager;

public class ButtonsPanel extends JPanel {
    private static ButtonsPanel instance;
    private JPanel rButtons;
    private final Image image;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private Enemies enemies;
    private Player player;
    private ConsolePanel console;

    public ButtonsPanel() {
        image = ImageManager.getInstance().getImage("buttonsPanel");
        Dimension size = new Dimension(image.getWidth(null), image.getHeight(null));
        setPreferredSize(size);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        add(rButtons);
        setOpaque(false);
        setBackground(null);
        setMixingCutoutShape(new Rectangle(0, 0, 0, 0));
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            ConsolePanel.getInstance().getConsole().append("Boton 1\n");
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConsolePanel.getInstance().getConsole().append("Boton 2\n");
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConsolePanel.getInstance().getConsole().append("Boton 3\n");
            }
        });
    }

    public static ButtonsPanel getInstance() {

        if (instance == null) {

            instance = new ButtonsPanel();
        }
        return instance;
    }
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        paintBackground(g2d);
    }

    public void paintBackground(Graphics2D g2d) {

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2d.drawImage(image, 0, 0, null);
    }

    private void createUIComponents() {
        button1 = new JButton();
        button1.setIcon(new ImageIcon(ImageManager.getInstance().getImage("pelear")));

        button2 = new JButton();
        button2.setIcon(new ImageIcon(ImageManager.getInstance().getImage("inventario")));

        button3 = new JButton();
        button3.setIcon(new ImageIcon(ImageManager.getInstance().getImage("salir")));

    }
}
