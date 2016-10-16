package lab2.panels;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;

import lab2.buttons.AcceptColourButton;

public class ShapeColorPanel extends JPanel {

	private static final long serialVersionUID = -2232773257402672519L;

	public ShapeColorPanel() {
		setLayout(new GridLayout(2,1));
		JPanel colorPanel = new JPanel(new FlowLayout());
		JSpinner redSpinner = addColour(colorPanel, "R:");
		JSpinner greenSpinner = addColour(colorPanel, "G:");
		JSpinner blueSpinner = addColour(colorPanel, "B:");
		add(colorPanel);
		add(new AcceptColourButton(redSpinner, greenSpinner, blueSpinner));
		
		
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
