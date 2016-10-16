package lab2.panels;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

public class ShapeChooserPanel extends JPanel {

	private static final long serialVersionUID = -837412013778194102L;

	public ShapeChooserPanel() {
		setLayout(new GridLayout(3, 1));
		JRadioButton rectangle = new JRadioButton("Prostokont");
		JRadioButton ellipse = new JRadioButton("Elipsa");
		JRadioButton polygon = new JRadioButton("Wielok¹t");

		ButtonGroup shapesGroup = new ButtonGroup();
		shapesGroup.add(rectangle);
		shapesGroup.add(ellipse);
		shapesGroup.add(polygon);

		add(rectangle);
		add(ellipse);
		add(polygon);

		Border centerBorder = BorderFactory.createTitledBorder("Kszta³t");
		setBorder(centerBorder);
	}

}
