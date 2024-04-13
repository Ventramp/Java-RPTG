package items.armors.knuckles;

import items.armors.ArmorType;
import items.armors.Armors;

import java.io.Serializable;

public class RustyKnuckles extends Armors implements Serializable {
    public RustyKnuckles() {
        super("Nudillos Oxidados","Nudillos oxidados\n No tienen nada de especial, pero son suficiente para no lastimarte", 50, 1, 10,10,10,10);
        this.type= ArmorType.HANDS;
    }
}
