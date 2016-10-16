package lab2.example;

import javax.swing.JFrame;

public class Gradient {
	JFrame ramka;

	public static void main(String[] args) {
		Gradient grad = new Gradient();
		grad.GUI();
	}

	public void GUI() {
		ramka = new JFrame();
		ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ramka.setTitle("Gradient: Red - Blue");
		MojPanelRysunkowy panelR = new MojPanelRysunkowy();
		ramka.getContentPane().add(panelR);
		ramka.setSize(300, 300);
		ramka.setVisible(true);
	}
}