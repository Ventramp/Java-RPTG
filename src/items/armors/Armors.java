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
    protected String name;

    public Armors(String name, String description, int price, int lv, int aHp, int aDef, int aDex) {
        super(name, description, price, lv);
        this.aHp = aHp;
        this.aDef = aDef;
        this.aDex = aDex;
    }

    public int getaHp() {return aHp;}
    public int getaDef() {return aDef;}
    public int getaDex() {return aDex;}

    public HashMap<Stats, Integer> getStats() {return stats;}

    public ArmorType getType() {return type;}

    @Override
    public String getName() {return name;}
}
