package items.weapons;

import java.io.Serializable;

public class Guns extends Weapons implements Serializable {
    public Guns(String name, String description, int price, int lv, int wAttk, int wAP) {
        super(name, description, price, lv, wAttk, wAP);
    }
}
