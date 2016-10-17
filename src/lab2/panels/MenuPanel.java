package lab2.panels;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class MenuPanel extends JPanel {

	private static final long serialVersionUID = -2792018285384425322L;

	public MenuPanel() {
		super();
		setLayout(new BorderLayout());

		add(new LoadImagePanel(), BorderLayout.NORTH);
		add(new ListPanel(), BorderLayout.CENTER);
		add(new ShapeSettingsPanel(), BorderLayout.SOUTH);
		
		
		Border centerBorder = BorderFactory.createTitledBorder("Ustawienia");
		setBorder(centerBorder);
	}
}
