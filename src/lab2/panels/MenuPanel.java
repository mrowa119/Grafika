package lab2.panels;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class MenuPanel extends JPanel {

	private static final long serialVersionUID = -2792018285384425322L;

	public MenuPanel(){
		super();
		setBackground(Color.BLACK);
		setLayout(new BorderLayout());
		
		add(new LoadImagePanel(), BorderLayout.NORTH);
		//add(new ShapeListPanel(), BorderLayout.Center);
		add(new ShapeSettingsPanel(), BorderLayout.SOUTH);
	}
}
