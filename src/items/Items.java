package items;

import javax.swing.*;

//CLASE ITEM PARA OBJETOS EQUIPABLES//
public class Items {
    protected String name;
    protected String description;
    protected int price;
    protected int lv;

    // Actualizacion de items
    public Items(String name, String description, int price) {

        this.name = name;
        this.description = description;
        this.price = price;
        this.lv =; lv
    }

    public void displayData() {

        JOptionPane.showMessageDialog(null,
                String.format("%s", description));
    }

//GETTER Y SETTERS DE ITEMS//
    public String getN() {return name;}
    public String getD() {return description;}
    public int getP() {return price;}
    public int getLv() {return lv;}

    public boolean getName() {
    }

    public Object getDescription() {
    }
}


