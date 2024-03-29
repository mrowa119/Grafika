package lab2.panels;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import lab2.labels.ShapeRender;
import lab2.lists.ShapeList;

public class ShapeListPanel extends JPanel {

	private static final long serialVersionUID = -5382550525730318339L;

	public ShapeListPanel() {
		super();
		setLayout(new GridLayout(1, 1));
		ShapeList shapeList = new ShapeList();
		shapeList.setCellRenderer(new ShapeRender());
		add(new JScrollPane(shapeList));
	}
}
