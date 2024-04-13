package items.armors.chest;

import items.armors.ArmorType;
import items.armors.Armors;

import java.io.Serializable;

public class EmpyChest extends Armors implements Serializable {
    public EmpyChest() {
        super("Vacio","",0,0,0,0,0,0);
        this.type= ArmorType.CHEST;
    }
}
