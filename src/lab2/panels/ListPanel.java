package lab2.panels;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import lab2.lists.ShapeList;

public class ListPanel extends JPanel {

	private static final long serialVersionUID = -5382550525730318339L;
	
	public ListPanel() {
		super();
		setLayout(new BorderLayout());
		
		add(new ShapeListPanel(), BorderLayout.CENTER);
		add(new ListButtonsPanel(),BorderLayout.SOUTH);
		
		Border centerBorder = BorderFactory.createTitledBorder("Obiekty");
        setBorder(centerBorder);
	}
}
