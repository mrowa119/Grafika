package lab2.lists;

import javax.swing.JList;

import lab2.globaldata.BackgoundData;
import lab2.shapes.MyShape;

public class ShapeList extends JList<MyShape> {

	private static final long serialVersionUID = 1251828228913881094L;

	public ShapeList() {
		super(BackgoundData.SHAPES_LIST);
	}
}
