package gui.panels;

import javax.swing.*;
import java.awt.*;
import util.managers.FontManager;
import util.managers.ImageManager;


public class ConsolePanel extends JPanel {
    private static ConsolePanel instance;
    private final Image image;
    private JPanel bgPanel;
    private JTextArea console;
    private JScrollPane consoleScroll;
    public static ConsolePanel getInstance() {

        if (instance == null) {

            instance = new ConsolePanel();
        }
        return instance;
    }

    private ConsolePanel() {

        image = ImageManager.getInstance().getImage("consolePanel");
        Dimension size = new Dimension(image.getWidth(null), image.getHeight(null));
        setPreferredSize(size);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        add(bgPanel);
        consoleScroll.setOpaque(false);
        consoleScroll.getViewport().setOpaque(false);
        consoleScroll.setBorder(BorderFactory.createEmptyBorder());

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

    public JTextArea getConsole() {
        return console;
    }

    public void setConsole(JTextArea console) {
        this.console = console;
    }

    private void createUIComponents() {
        console=new JTextArea();
        console.setForeground(Color.WHITE);
        console.setOpaque(false);
        console.setLineWrap(true);
        console.setWrapStyleWord(true);
        console.setAutoscrolls(true);
        console.setEditable(true);
        console.setAutoscrolls(true);
        console.setWrapStyleWord(true);
        console.setDropMode(DropMode.INSERT);
        console.requestFocus();
        consoleScroll=new JScrollPane(console);
        consoleScroll.setOpaque(false);
        consoleScroll.getViewport().setOpaque(false);
        consoleScroll.setBorder(BorderFactory.createEmptyBorder());
        consoleScroll.setAutoscrolls(true);
    }
}
