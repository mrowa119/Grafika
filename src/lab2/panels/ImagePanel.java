package lab2.panels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JPanel;

import lab2.globaldata.BackgoundData;

public class ImagePanel extends JPanel {

	private static final long serialVersionUID = 5275308904348754719L;

	public ImagePanel() {
		super();
		setLayout(new GridLayout(1, 1));
		setBackground(Color.GREEN);
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(BackgoundData.BACKGORUND_IMAGE, 0, 0, null);
	}
	
//	 @Override
//     protected void paintComponent(Graphics g) {
//         super.paintComponent(g);
//         g.drawImage(BackgoundData.BACKGORUND_IMAGE, 0, 0, null);
//     }
}
