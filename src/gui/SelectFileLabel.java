package gui;

import gui.dataLabels.Logolabel;
import gui.panels.ConsolePanel;
import util.managers.FileManager;
import util.managers.FontManager;
import players.Player;
import util.managers.ImageManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

// Importa la clase GeneralScreen


public class SelectFileLabel extends JPanel {
	private static SelectFileLabel instance;
	private JPanel rootPane;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JLabel gameIcon;
	private final FontManager fontManager;
	private int slot;
	private Player player;
	private Image image;
	private ImageIcon icono;
	public static SelectFileLabel getInstance() {
		if (instance == null) {
			instance = new SelectFileLabel();
		}
		return instance;
	}

	public static void main(String[] args) {
		SelectFileLabel selectFileWindow = new SelectFileLabel();
	}

	public SelectFileLabel() {
		icono = new ImageIcon(ImageManager.getInstance().getImage("icono"));
		add(rootPane);
		image = ImageManager.getInstance().getImage("filescreen");
		fontManager = FontManager.getInstance();
		button1.setIcon(new ImageIcon(ImageManager.getInstance().getImage("slot1")));
		button2.setIcon(new ImageIcon(ImageManager.getInstance().getImage("slot2")));
		button3.setIcon(new ImageIcon(ImageManager.getInstance().getImage("slot3")));
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				slot=1;
				loadOrNew();
			}
		});

		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				slot=2;
				loadOrNew();
			}
		});

		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				slot=3;
				loadOrNew();
			}
		});
	}
	private void loadOrNew(){
		try {
			player = FileManager.loadGame(new File("files\\game" + slot + ".dat"));
			int respuesta = JOptionPane.showOptionDialog(
					null,
					"Usuario: "+player.getName()+"\nNivel: "+player.getLevel()+"\n¿Quieres continuar esta partida?",
					"¿Continuar?",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					icono,
					new Object[]{"Sí", "No"},
					"Sí");
			if (respuesta == JOptionPane.YES_OPTION) {
				GeneralScreen.getInstance().startGame();
				ConsolePanel.getInstance().getConsole().append("Bienvenido de Vuelta");
				SelectfileWindow.getInstance().dispose();
			} else {}
		} catch (Exception i) {
			int respuesta = JOptionPane.showConfirmDialog(
					null,
					"                    Slot Vacio\n¿Quieres iniciar una nueva partida?",
					"Nueva Partida",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					icono);
			if (respuesta == JOptionPane.YES_OPTION) {
				player = new Player(JOptionPane.showInputDialog("Ingresa el nombre del jugador:"));
				GeneralScreen.getInstance().startGame();
				String message = String.format("¡Bienvenido a la aventura, %s!\n", player.getName());
				ConsolePanel.getInstance().getConsole().append(message);
				SelectfileWindow.getInstance().dispose();
			}else {}
		}
	}
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		paintBackground(g2d);
	}

	public void paintBackground(Graphics2D g2d) {

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2d.drawImage(image, 0, 0, null);
	}
	private void createUIComponents() {
		gameIcon= Logolabel.getInstance();
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
