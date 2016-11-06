package lab2.labels;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import lab2.shapes.MyShape;

public class ShapeRender extends JLabel implements ListCellRenderer<MyShape> {

	private static final long serialVersionUID = -1203777281768503740L;

	@Override
	public Component getListCellRendererComponent(JList<? extends MyShape> list, MyShape myShape, int index,
			boolean isSelected, boolean cellHasFocus) {
		setIcon(new ImageIcon(myShape.getIcon()));
		setText(myShape.toString());
		return this;
	}

}
