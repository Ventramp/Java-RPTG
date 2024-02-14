package items.weapons;

import items.Items;

public class Weapons extends Items {
    protected String name;
    protected String description;
    protected int price;
    protected int wAttk;
    protected int wLV;

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public int getPrice() {
        return price;
    }
    public int getwAttk() {
        return wAttk;
    }
    public int getwLV() {
        return wLV;
    }
}
