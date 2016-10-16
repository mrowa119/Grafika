package lab2.panels;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import lab2.buttons.LoadImageButton;

public class LoadImagePanel extends JPanel {

	private static final long serialVersionUID = 6115044369568732965L;

	public LoadImagePanel() {
		super();
		setLayout(new GridLayout(1, 1));
		add(new LoadImageButton());

		Border centerBorder = BorderFactory.createTitledBorder("T³o");
		setBorder(centerBorder);
	}
}
