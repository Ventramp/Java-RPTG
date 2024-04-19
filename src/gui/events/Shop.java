package gui.events;

import enemies.Enemies;
import gui.GeneralScreen;
import items.Items;
import items.armors.boots.LeatherBoots;
import items.armors.helmets.LeatherHelmet;
import items.armors.knuckles.RustyKnuckles;
import items.weapons.Guns;
import items.weapons.Sword;
import players.Player;

import javax.swing.*;
import java.util.List;

public class Shop {
	public static Shop instance;
	private Player player;
	public Shop() {
		this.player = GeneralScreen.getInstance().getPlayer();
	}
	public static Shop getInstance() {

		if (instance == null) {

			instance = new Shop();
		}
		return instance;
	}

	public void sell(Player player) {
		List<Items> playerItems = player.getInventory().getItems();
		if (playerItems.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No tienes elementos en tu inventario para vender.");
			return;
		}

		StringBuilder message = new StringBuilder("Selecciona un elemento para vender:\n");
		for (int i = 0; i < playerItems.size(); i++) {
			Items item = playerItems.get(i);
			message.append(String.format("%d. %s - %d\n", i + 1, item.getName(), item.getPrice()));
		}
		message.append("0. Salir\n");

		try {
			int option = Integer.parseInt(JOptionPane.showInputDialog(message.toString()));
			if (option == 0) {
			}
			else if (option > 0 && option <= playerItems.size()) {
				Items selectedItem = playerItems.get(option - 1);
				player.getInventory().removeItem(selectedItem); // Remueve el elemento del inventario del jugador
				player.setGold(player.getGold()+selectedItem.getPrice()); // Incrementa el oro del jugador por la mitad del precio del objeto
				JOptionPane.showMessageDialog(null, String.format("Has vendido %s por %d monedas de oro.", selectedItem.getName(), selectedItem.getPrice()));
			} else {
				JOptionPane.showMessageDialog(null, "Opción inválida.");
				sell(player); // Vuelve a llamar a la función si la opción es inválida
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Opción inválida.");
			sell(player);
		}
	}
		public void buy (Player player){
			String[] options = {"Botas de cuero", "Casco de cuero", "Nudillos Oxidados", "Espada", "Pistola", "Salir"};

			// Mostrar los objetos disponibles para comprar
			StringBuilder message = new StringBuilder("Selecciona un objeto para comprar:\n");
			for (int i = 0; i < options.length; i++) {
				message.append(String.format("%d. %s\n", i + 1, options[i]));
			}

			try {
				int option = Integer.parseInt(JOptionPane.showInputDialog(message.toString()));
				if (option == 0) {}
				else if (option > 0 && option <= options.length - 1) {
					String itemName = options[option - 1];
					Items item = createItemByName(itemName); // Crear el objeto seleccionado
					if (item != null) {
						player.getInventory().addItem(item); // Agregar el objeto al inventario del jugador
						JOptionPane.showMessageDialog(null, String.format("Has comprado %s.", itemName));
					} else {
						JOptionPane.showMessageDialog(null, "No se pudo crear el objeto seleccionado.");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Opción inválida.");
					buy(player); // Vuelve a llamar a la función si la opción es inválida
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Opción inválida.");
				buy(player); // Vuelve a llamar a la función si ocurre una excepción
			}
		}

		// Método para crear un objeto por su nombre
		private Items createItemByName (String itemName){
			switch (itemName) {
				case "Botas de cuero":
					return new LeatherBoots();
				case "Casco de cuero":
					return new LeatherHelmet();
				case "Nudillos Oxidados":
					return new RustyKnuckles();
				case "Espada":
					return new Sword();
				case "Pistola":
					return new Guns();
				default:
					return null; // Devuelve null si no se puede crear el objeto
			}
		}
	}
