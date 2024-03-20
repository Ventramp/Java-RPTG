package players;

import items.Items;
import util.FixedArrayList;

import java.io.Serializable;

public class Inventory implements Serializable {
        private final FixedArrayList<Items> items;

        public Inventory() {

            items = new FixedArrayList<> (15);
        }

        public void addItem(Items item) {

            System.out.println(items.add(item) ? item.getName() + " has been added to your inventory." : "Inventory is full.");
        }

        public void removeItem(Items item) {

            items.remove(item);
        }

        public FixedArrayList<Items> getItems() {

            return items;
        }

        public void printItems() {

            if (items.isEmpty()) {

                System.out.println("Inventory is empty.");
            } else {
                System.out.println("Inventory:");
                for (Items item : items) {
                    System.out.println(item.getName() + " - " + item.getDescription());
                }
            }
        }
    }
