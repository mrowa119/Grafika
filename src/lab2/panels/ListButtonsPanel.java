package lab2.panels;

import java.awt.GridLayout;

import javax.swing.JPanel;

import lab2.buttons.LoadListButton;
import lab2.buttons.RemoveShapeButton;
import lab2.buttons.SaveListButton;

public class ListButtonsPanel extends JPanel {

	private static final long serialVersionUID = -4250722870062327973L;

	public ListButtonsPanel() {
		super();
		setLayout(new GridLayout(3, 1));

		add(new SaveListButton());
		add(new LoadListButton());
		add(new RemoveShapeButton());
	}
}
