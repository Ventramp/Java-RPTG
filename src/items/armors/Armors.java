package items.armors;

import items.Items;
import players.Stats;

import java.io.Serializable;
import java.util.HashMap;

public abstract class Armors extends Items implements Serializable {
    protected HashMap<Stats, Integer> stats = new HashMap<>();
    protected ArmorType type;
    protected int aHp;
    protected int aDef;
    protected int aDex;
    protected int attk;

    public Armors(String name, String description, int price, int lv, int aHp, int aDef, int aDex, int attk) {
        super(name, description, price, lv);
        this.aDef=aDef;
        this.aDex=aDex;
        this.aHp=aHp;
        this.attk=attk;
    }

    public HashMap<Stats, Integer> getStats() {return stats;}

    public ArmorType getType() {return type;}
    public void setType(ArmorType type) {

        this.type = type;
    }

    public int getaHp() {
        return aHp;
    }

    public int getaDef() {
        return aDef;
    }

    public int getaDex() {
        return aDex;
    }

    public int getAttk() {
        return attk;
    }
}
