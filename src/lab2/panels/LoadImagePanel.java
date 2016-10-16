package lab2.panels;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import lab2.buttons.LoadImageButton;

public class LoadImagePanel extends JPanel {

	private static final long serialVersionUID = 6115044369568732965L;

	public LoadImagePanel() {
		super();
		add(new LoadImageButton());

		Border centerBorder = BorderFactory.createTitledBorder("T�o");
		setBorder(centerBorder);
	}
}
