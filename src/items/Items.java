package items;

import javax.swing.*;

//CLASE ITEM PARA OBJETOS EQUIPABLES//
public abstract class Items {
    protected final String name;
    protected final String description;
    protected final int price;
    protected  final int lv;

    // Actualizacion de items
    public Items(String name, String description, int price, int lv) {

        this.name = name;
        this.description = description;
        this.price = price;
        this.lv = lv;
    }

    public void displayWData() {

        JOptionPane.showMessageDialog(null,
                String.format("%s", description));
    }

//GETTER Y SETTERS DE ITEMS//

    public String getName() {
        return name;}

    public String getDescription() {return description;}

    public int getPrice() {return price;}

    public int getLv() {return lv;}
}


