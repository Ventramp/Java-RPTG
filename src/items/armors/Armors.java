package items.armors;

import items.Items;

public class Armors extends Items {
    protected int aHp;
    protected int aDef;

    public Armors() {
        this.name = "Sin Armadura";
        this.description = "N/A";
        this.price = 0;
        this.lv = 0;
        this.aHp = 0;
        this.aDef = 0;
    }
    public void displayAInfo(){
        //aparecer caracteristicas del item Armadura//
    }

    public int getaHp() {return aHp;}
    public int getaD() {return aDef;}
}
