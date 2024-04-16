package gui.dataLabels;

import util.managers.ImageManager;

import javax.swing.*;
import java.awt.*;

public class Logolabel extends JLabel {

	private static Logolabel instance;
	private final Image portrait;

	public static Logolabel getInstance() {

		if (instance == null) {

			instance = new Logolabel();
		}
		return instance;
	}

	private Logolabel() {

		portrait = ImageManager.getInstance().getImage("logo");
		Dimension size = new Dimension(portrait.getWidth(null), portrait.getHeight(null));
		setPreferredSize(size);
		setMaximumSize(size);
		setMinimumSize(size);
		setOpaque(false);
	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2d.drawImage(portrait, 0, 0, null);
	}
}
