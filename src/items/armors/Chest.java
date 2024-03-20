package items.armors;


import java.io.Serializable;

public abstract class Chest extends Armors implements Serializable {
    public Chest(String name, String description, int price, int lv, int aHp, int aDef, int aDex) {
        super(name, description, price, lv, aHp, aDef, aDex);
    }
}
