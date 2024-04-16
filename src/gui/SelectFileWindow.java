package gui;

import gui.panels.BackgroundPanel;
import util.managers.FileManager;
import util.managers.FontManager;
import players.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

// Importa la clase GeneralScreen


public class SelectFileWindow extends JFrame {
	private static SelectFileWindow instance;
	private JPanel rootPane;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JLabel gameName;
	private JLabel gameIcon;
	private final FontManager fontManager;
	private int slot;
	private Player player;
	public static SelectFileWindow getInstance() {
		if (instance == null) {
			instance = new SelectFileWindow();
		}
		return instance;
	}

	public static void main(String[] args) {
		SelectFileWindow selectFileWindow = new SelectFileWindow();
	}

	public SelectFileWindow() {
		setSize(1280, 800);
		fontManager = FontManager.getInstance();
		setTitle("Selección de archivo");
		setContentPane(rootPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				slot=1;
				try {
					player = FileManager.loadGame(new File("files\\game" + slot + ".dat"));
					JOptionPane.showMessageDialog(null,"Bienvenido de Vuelta");
					GeneralScreen.getInstance().startGame();
				} catch (Exception i) {
					player = new Player(JOptionPane.showInputDialog("Ingresa el nombre del jugador:"));
					GeneralScreen.getInstance().startGame();
				}
			}
		});

		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				slot=2;
				try {
					player = FileManager.loadGame(new File("files\\game" + slot + ".dat"));
					JOptionPane.showMessageDialog(null,"Bienvenido de Vuelta");
					GeneralScreen.getInstance().startGame();
				} catch (Exception i) {
					player = new Player(JOptionPane.showInputDialog("Ingresa el nombre del jugador:"));
					GeneralScreen.getInstance().startGame();
				}
			}
		});

		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				slot=3;
				try {
					player = FileManager.loadGame(new File("files\\game" +slot+ ".dat"));
					JOptionPane.showMessageDialog(null,"Bienvenido de Vuelta");
					GeneralScreen.getInstance().startGame();
				} catch (Exception i) {
					player = new Player(JOptionPane.showInputDialog("Ingresa el nombre del jugador:"));
					GeneralScreen.getInstance().startGame();
				}
			}
		});
	}
	private void createUIComponents() {

		button1 = new JButton();
		button2 = new JButton();
		button3 = new JButton();
	}

	public Player getPlayer() {

		return player;
	}

	public int getSlot() {

		return slot;
	}
}
