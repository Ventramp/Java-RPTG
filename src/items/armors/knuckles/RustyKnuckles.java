package items.armors.knuckles;

import items.armors.ArmorType;
import items.armors.Armors;

import java.io.Serializable;

public class RustyKnuckles extends Armors implements Serializable {
    public RustyKnuckles() {
        super("Nudillos Oxidados","No tienen nada de especial, pero son suficiente para no lastimarte", 200, 1, 0,0,0,10);
        this.type= ArmorType.HANDS;
    }
}
