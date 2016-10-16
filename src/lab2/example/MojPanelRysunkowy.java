package lab2.example;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

class MojPanelRysunkowy extends JPanel {
	private static final long serialVersionUID = 6936649584693886541L;

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		GradientPaint gradient = new GradientPaint(70, 70, Color.RED, 150, 150, Color.BLUE);
		g2d.setPaint(gradient);
		g2d.fillOval(70, 70, 100, 100);
	}
}