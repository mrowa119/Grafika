package lab2.panels;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class ShapeListPanel extends JPanel {

	private static final long serialVersionUID = -5382550525730318339L;
	
	public ShapeListPanel() {
		super();
		setLayout(new BorderLayout());
		
		
		add(new ListButtonsPanel(),BorderLayout.SOUTH);
		
		Border centerBorder = BorderFactory.createTitledBorder("Obiekty");
        setBorder(centerBorder);
	}
}
