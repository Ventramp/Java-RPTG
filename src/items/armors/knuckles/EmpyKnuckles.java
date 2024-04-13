package items.armors.knuckles;

import items.armors.ArmorType;
import items.armors.Armors;

import java.io.Serializable;

public class EmpyKnuckles extends Armors implements Serializable {
    public EmpyKnuckles() {
        super("Vacio","",0,0,0,0,0,0);
        this.type= ArmorType.HANDS;
    }


}
