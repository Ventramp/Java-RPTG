package items.armors.helmets;

import items.armors.Armors;

public abstract class Helmet extends Armors {
    public Helmet(String name, String description, int price, int lv, int aHp, int aDef, int aDex) {
        super(name, description, price, lv, aHp, aDef, aDex);
    }
}
