package graphInterface.dataLabels;

import characters.BasicCharacter;
import players.Player;

import javax.swing.*;
import java.awt.*;

public class HpLabel extends JLabel {
    private BasicCharacter character;
    private String text;
    private Image image;

    public HpLabel(Player character) {
        this.character =character;
        //init();//

    }

}
