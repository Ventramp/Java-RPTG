package gui;

import util.managers.ImageManager;

import javax.swing.*;

public class SelectfileWindow extends JFrame {
	private static SelectfileWindow instance;
	private JPanel rWindow;
	private ImageIcon icono;
	private JPanel selectfileLabel;
	public static SelectfileWindow getInstance() {
		if (instance == null) {
			instance = new SelectfileWindow();
		}
		return instance;
	}

	public SelectfileWindow(){
		setTitle("Selección de archivo");
		setContentPane(rWindow);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		icono = new ImageIcon((ImageManager.getInstance().getImage("icono")));
		setIconImage(icono.getImage());
	}

	private void createUIComponents() {
		selectfileLabel = SelectFileLabel.getInstance();
	}
}
