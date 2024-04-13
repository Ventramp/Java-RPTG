package items.armors.boots;

import items.armors.ArmorType;
import items.armors.Armors;

import java.io.Serializable;

public class LeatherBoots extends Armors implements Serializable {


    public LeatherBoots(String name, String description, int price, int lv, int aHp, int aDef, int aDex, int attk) {
        super(name, description, price, lv, aHp, aDef, aDex, attk);
        this.type= ArmorType.LEGS;
    }
}
