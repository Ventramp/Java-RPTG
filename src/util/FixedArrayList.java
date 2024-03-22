package util;

import items.armors.Armors;
import items.weapons.Weapons;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FixedArrayList<T> extends ArrayList<T> implements Serializable {

    private int capacity;

    public FixedArrayList(int capacity) {

        super(capacity);
        this.capacity = capacity;
    }

    @Override
    public boolean add(T e) {

        return size() < capacity && super.add(e);
    }

    public void expandCapacity(int amount) {

        capacity += amount;
        ensureCapacity(capacity);
    }

    public List<Armors> filterArmors() {

        List<Armors> armors = new ArrayList<>();
        for (T item : this) {
            if (item instanceof Armors) {
                armors.add((Armors) item);
            }
        }
        return armors;
    }

    public List<Weapons> filterWeapons() {

        List<Weapons> weapons = new ArrayList<>();
        for (T item : this) {
            if (item instanceof Weapons) {
                weapons.add((Weapons) item);
            }
        }
        return weapons;
    }
}
