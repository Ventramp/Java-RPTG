package items.armors;

import items.Items;

public abstract class Armors extends Items {
    protected int aHp;
    protected int aDef;
    protected int aDex;

    public Armors(String name, String description, int price, int lv, int aHp, int aDef, int aDex) {
        super(name, description, price, lv);
        this.aHp = aHp;
        this.aDef = aDef;
        this.aDex = aDex;
    }

    public int getaHp() {return aHp;}

    public void setaHp(int aHp) {this.aHp = aHp;}

    public int getaDef() {return aDef;}

    public void setaDef(int aDef) {this.aDef = aDef;}

    public int getaDex() {return aDex;}

    public void setaDex(int aDex) {this.aDex = aDex;}
}
