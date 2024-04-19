package items.armors.helmets;

import items.armors.ArmorType;
import items.armors.Armors;

import java.io.Serializable;

public class LeatherHelmet extends Armors implements Serializable {

    public LeatherHelmet() {
        super("Casco de Cuero", "Casco sencillo de cuero", 200, 1, 10,0, 0, 0);
        this.type= ArmorType.HEAD;
    }

}
