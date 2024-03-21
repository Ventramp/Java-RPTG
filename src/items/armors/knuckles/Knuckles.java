package items.armors.knuckles;


import items.armors.Armors;

import java.io.Serializable;

public  abstract class Knuckles extends Armors implements Serializable {
    public Knuckles(String name, String description, int price, int lv, int aHp, int aDef, int aDex) {
        super(name, description, price, lv, aHp, aDef, aDex);
    }
}
