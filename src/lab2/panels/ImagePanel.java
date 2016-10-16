package lab2.panels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import lab2.globaldata.BackgoundData;

public class ImagePanel extends JPanel {

	private static final long serialVersionUID = 5275308904348754719L;

	public ImagePanel() {
		super();
		setLayout(new GridLayout(1, 1));
		setBackground(Color.GREEN);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// g.drawImage(BackgoundData.BACKGORUND_IMAGE, 0, 0, null);
		if (BackgoundData.isBackgroundSet()) {
			Graphics2D g2d = (Graphics2D) g.create();
			int tileWidth = ((BufferedImage) BackgoundData.BACKGORUND_IMAGE).getWidth();
			int tileHeight = ((BufferedImage) BackgoundData.BACKGORUND_IMAGE).getHeight();
			for (int y = 0; y < getHeight(); y += tileHeight) {
				for (int x = 0; x < getWidth(); x += tileWidth) {
					g2d.drawImage(BackgoundData.BACKGORUND_IMAGE, x, y, this);
				}
			}
			g2d.dispose();
		}
	}

}
