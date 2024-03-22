package items.drops;

import items.Items;

import java.io.Serializable;

public class Compass extends Items implements Serializable {
    public Compass() {
        super("Brujula","Es una brujula, la usan para saber en que direccion se mueven, son muy comunes", 50, 0);
    }
}
