package players;

import gui.panels.ConsolePanel;
import items.Items;
import items.armors.Armors;
import items.weapons.Weapons;
import players.Player;
import util.FixedArrayList;

import javax.swing.*;
import java.io.Serializable;
import java.util.List;

public class Inventory implements Serializable {

    private final FixedArrayList<Items> items;

    public Inventory() {

        items = new FixedArrayList<>(15);
    }

    public void equipArmorMenu(Player player) {

        List<Armors> armors = items.filterArmors();
        String message = getArmorMessage(armors);
        try {
            int option = Integer.parseInt(JOptionPane.showInputDialog(message));
            if (option > 0 && option <= armors.size()) equipArmorAction(player, armors, option);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Opción inválida.");
            equipArmorMenu(player);
        }
    }

    private String getArmorMessage(List<Armors> armors) {

        StringBuilder message = new StringBuilder("Equipar Armadura:\n");
        String itemMessage;
        Armors actualArmor;
        for (int i = 0; i < armors.size(); i++) {

            actualArmor = armors.get(i);
            itemMessage = String.format("%d. %s - %s\n", i + 1, actualArmor.getName(), actualArmor.getDescription());
            message.append(itemMessage);
        }
        message.append("0. Salir\n");
        return message.toString();
    }

    private void equipArmorAction(Player player, List<Armors> armors, int option) {

        Armors selectedArmor = armors.get(option - 1);
        switch (selectedArmor.getType()) {
            case HEAD -> {
                if (player.getHelmet() != null) items.add(player.getHelmet());
            }
            case CHEST -> {
                if (player.getChest() != null) items.add(player.getChest());
            }
            case HANDS -> {
                if (player.getKnuckles() != null) items.add(player.getKnuckles());
            }
            case LEGS -> {
                if (player.getBoots() != null) items.add(player.getBoots());
            }
        }
        player.equipArmor(selectedArmor);
        player.equipADialog(selectedArmor);
        items.remove(selectedArmor);

    }

    public void equipWeaponMenu(Player player) {

        List<Weapons> weapons = items.filterWeapons();
        String message = getWeaponMessage(weapons);
        try {
            int option = Integer.parseInt(JOptionPane.showInputDialog(message));
            if (option > 0 && option <= weapons.size()) {

                equipWeaponAction(player, weapons, option);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Opción inválida.");
            equipWeaponMenu(player);
        }
    }

    private void equipWeaponAction(Player player, List<Weapons> weapons, int option) {

        Weapons selectedWeapon = weapons.get(option - 1);
        if (player.getWeapon() != null)
            items.add(player.getWeapon());
        player.equipWeapon(selectedWeapon);
        player.equipWDialog(selectedWeapon);
        items.remove(selectedWeapon);
    }

    private String getWeaponMessage(List<Weapons> weapons) {

        StringBuilder message = new StringBuilder("Equipar Arma:\n");
        String itemMessage;
        Weapons actualWeapon;
        for (int i = 0; i < weapons.size(); i++) {

            actualWeapon = weapons.get(i);
            itemMessage = String.format("%d. %s - %s\n", i + 1, actualWeapon.getName(), actualWeapon.getDescription());
            message.append(itemMessage);
        }
        message.append("0. Salir\n");
        return message.toString();
    }

    public void addItem(Items item) {

        String addMessage = String.format("%s se ha agregado al Inventario!\n\n", item.getName());
        ConsolePanel.getInstance().getConsole().append(items.add(item) ? addMessage : "Inventario Lleno.");
    }

    public void removeItem(Items item) {

        items.remove(item);
    }

    public FixedArrayList<Items> getItems() {

        return items;
    }

    public void printItems() {

        if (items.isEmpty()) {

            JOptionPane.showMessageDialog(null,"Inventario Vació.");
        } else {
            StringBuilder message = new StringBuilder("Inventario:\n");
            String itemMessage;
            for (Items item : items) {
                itemMessage = String.format("%s - %s\n", item.getName(), item.getDescription());
                message.append(itemMessage);
            }
            JOptionPane.showMessageDialog(null,message.toString());
        }
    }
}
