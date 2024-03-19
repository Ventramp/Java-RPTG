package util;

import java.util.ArrayList;

//Crear el Inventario
public class FixedArrayList<T> extends ArrayList<T> {
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
}