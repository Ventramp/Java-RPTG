package items.armors.boots;

import items.armors.ArmorType;
import items.armors.Armors;

import java.io.Serializable;

public class LeatherBoots extends Armors implements Serializable {


    public LeatherBoots() {
        super("Botas de Cuero", "botas sencillas de cuero", 200, 1, 0,0, 5, 0);
        this.type= ArmorType.LEGS;
    }
}
