package lab2.panels;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class ShapeSettingsPanel extends JPanel {
	private static final long serialVersionUID = -837412013778194102L;

	public ShapeSettingsPanel() {
		super();
		
		setLayout(new BorderLayout());
		
		add(new ShapeChooserPanel(), BorderLayout.NORTH);
		add(new ShapeColorPanel(), BorderLayout.SOUTH);
	}
}
