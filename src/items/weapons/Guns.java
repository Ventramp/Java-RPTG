package items.weapons;

import java.io.Serializable;

public class Guns extends Weapons implements Serializable {
    public Guns() {
        super("Pistola Vieja", "Arma de un antiguo marinero", 200, 1, 0,20);
    }
}
