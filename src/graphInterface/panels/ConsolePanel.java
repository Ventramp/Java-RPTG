package graphInterface.panels;

import javax.swing.*;
import java.awt.*;

public class ConsolePanel extends JPanel {
    private static ConsolePanel instance;
    private JPanel rConsole;
    private JTextArea console;
    private JScrollPane consoleScroll;

    public ConsolePanel() {
        Dimension size = new Dimension();
        setPreferredSize(size);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        consoleScroll.setOpaque(false);
        consoleScroll.getViewport().setOpaque(false);
        consoleScroll.setBorder(BorderFactory.createEmptyBorder());
    }

    public static ConsolePanel getInstance() {

        if (instance == null) {

            instance = new ConsolePanel();
        }
        return instance;
    }

    private void createUIComponents() {

        console = new JTextArea();
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
        consoleScroll = new JScrollPane(console);
        consoleScroll.setOpaque(false);
        consoleScroll.getViewport().setOpaque(false);
        consoleScroll.setBorder(BorderFactory.createEmptyBorder());
        consoleScroll.setAutoscrolls(true);
    }
}
