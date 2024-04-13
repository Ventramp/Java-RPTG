package items.armors.boots;

import items.armors.ArmorType;
import items.armors.Armors;

import java.io.Serializable;

public class EmpyBoots extends Armors implements Serializable {
    public EmpyBoots() {
        super("Vacio","",0,0,0,0,0,0);
        this.type= ArmorType.LEGS;
    }
}
