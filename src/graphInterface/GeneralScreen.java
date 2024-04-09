package graphInterface;

import javax.swing.*;

public class GeneralScreen extends JFrame {
    private static GeneralScreen instance;
    private JPanel retenedor;
    private JPanel buttonsPanel;


    public GeneralScreen() {
    setSize(1280,800);
    setName("PirATEEZ Quest");
    setVisible(true);
    setLocationRelativeTo(null);
    }
}
