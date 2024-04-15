package gui;

import gui.events.BackGroundButton;
import gui.panels.BackgroundPanel;
import util.managers.FileManager;
import util.managers.FontManager;
import players.Player;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;

// Importa la clase GeneralScreen
import gui.GeneralScreen;

public class SelectFileWindow extends JFrame {
	private JPanel rootPane;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JLabel gameName;
	private JLabel gameIcon;
	private final FontManager fontManager;

	public static void main(String[] args) {
		SelectFileWindow selectFileWindow = new SelectFileWindow();
	}

	public SelectFileWindow() {
		fontManager = FontManager.getInstance();
		setTitle("Ventana de selección de archivo");
		changeFont();
		setContentPane(rootPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
	}

	private void changeFont() {
		gameName.setOpaque(false);
		gameName.setBackground(null);
		gameName.setText("HOLA");
		gameName.setIcon(new ImageIcon("img\\23.png"));
		gameName.setFont(fontManager.getFont("Game Title"));
		gameIcon.setIcon(new ImageIcon("img\\17.png"));
	}

	private void createUIComponents() {
		rootPane = new BackgroundPanel(new ImageIcon("img\\back_1.png").getImage());
		File load;
		for (int i = 1; i <= 3; i++) {
			load = new File("files\\game" + i + ".dat");
			if (load.exists()) {
				try {
					Player player = FileManager.loadGame(load);
					switch (i) {
						case 1 -> button1 = new BackGroundButton(this, player.toString(), i);
						case 2 -> button2 = new BackGroundButton(this, player.toString(), i);
						case 3 -> button3 = new BackGroundButton(this, player.toString(), i);
					}
				} catch (FileNotFoundException e) {
					JOptionPane.showMessageDialog(this, "Error al cargar el archivo",
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				switch (i) {
					case 1 -> button1 = new BackGroundButton(this, "--LIBRE--", i);
					case 2 -> button2 = new BackGroundButton(this, "--LIBRE--", i);
					case 3 -> button3 = new BackGroundButton(this, "--LIBRE--", i);
				}
			}
		}
	}

	// Método para iniciar el juego desde SelectFileWindow
	public void iniciarJuego() {
		GeneralScreen.getInstance().startGame();
	}
}
