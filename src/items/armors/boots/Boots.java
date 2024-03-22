package items.armors.boots;

import items.armors.Armors;

public abstract class Boots extends Armors {
    public Boots(String name, String description, int price, int lv, int aHp, int aDef, int aDex) {
        super(name, description, price, lv, aHp, aDef, aDex);
    }
}
