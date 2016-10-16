package lab2.panels;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

import lab2.globaldata.CoursorData;

public class ShapeChooserPanel extends JPanel {

	private static final long serialVersionUID = -837412013778194102L;

	public ShapeChooserPanel() {
		setLayout(new GridLayout(3, 1));
		JRadioButton rectangle = new JRadioButton("Prostok¹t", true);
		JRadioButton ellipse = new JRadioButton("Elipsa");
		JRadioButton polygon = new JRadioButton("Wielok¹t");

		rectangle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CoursorData.SHAPE_COURSOR = 0;
			}
		});
		ellipse.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CoursorData.SHAPE_COURSOR = 1;
			}
		});
		polygon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CoursorData.SHAPE_COURSOR = 2;
			}
		});

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
