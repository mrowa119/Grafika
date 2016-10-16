package lab2.panels;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;

import lab2.buttons.acceptColourButton;

public class ShapeColorPanel extends JPanel {

	private static final long serialVersionUID = -2232773257402672519L;

	public ShapeColorPanel() {
		setLayout(new GridLayout(4,1));
		JSpinner redSpinner = addColour(this, "R:");
		JSpinner greenSpinner = addColour(this, "G:");
		JSpinner blueSpinner = addColour(this, "B:");
		add(new acceptColourButton(redSpinner, greenSpinner, blueSpinner));
		
		
		Border centerBorder = BorderFactory.createTitledBorder("Kolor");
        setBorder(centerBorder);
	}
	
	
	private JSpinner addColour(JPanel panel, String colorLabel){
		JSpinner colourSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 255, 1));
		JPanel colourPanel = new JPanel(new FlowLayout());
		colourPanel.add(new JLabel(colorLabel));
		colourPanel.add(colourSpinner);
		panel.add(colourPanel);
		return colourSpinner;
	}
}
