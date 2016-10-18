package lab2.panels;

import java.awt.GridLayout;

import javax.swing.JPanel;

import lab2.buttons.LoadListButton;
import lab2.buttons.RemoveShapeButton;
import lab2.buttons.SaveListButton;
import lab2.buttons.UnselectButton;

public class ListButtonsPanel extends JPanel {

	private static final long serialVersionUID = -4250722870062327973L;

	public ListButtonsPanel() {
		super();
		setLayout(new GridLayout(4, 1));

		add(new UnselectButton());
		add(new SaveListButton());
		add(new LoadListButton());
		add(new RemoveShapeButton());
	}
}
