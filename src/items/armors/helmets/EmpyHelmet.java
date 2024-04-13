package items.armors.helmets;

import items.armors.ArmorType;
import items.armors.Armors;

import java.io.Serializable;

public class EmpyHelmet extends Armors implements Serializable {
    public EmpyHelmet() {
        super("Vacio","",0,0,0,0,0,0);
        this.type= ArmorType.HEAD;
    }
}
