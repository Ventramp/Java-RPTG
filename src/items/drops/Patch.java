package items.drops;

import items.Items;

import java.io.Serializable;

public class Patch extends Items implements Serializable {
    public Patch(String name, String description, int price, int lv) {
        super("Parche","Parche que se utiliza para ocultar cicatrices en los ojos y verse intimidante", 350, 0);
    }
}
