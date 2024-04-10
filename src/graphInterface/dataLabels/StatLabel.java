package graphInterface.dataLabels;

import javax.swing.*;

public class StatLabel extends JLabel {
    private String displayText;

    public StatLabel(String displayText) {
        this.displayText = displayText;
    }
    public void setDisplayText(String displayText) {

        this.displayText = displayText;
    }
}
