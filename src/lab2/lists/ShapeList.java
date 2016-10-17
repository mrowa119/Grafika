package lab2.lists;

import javax.swing.JList;

import lab2.shapes.MyShape;

public class ShapeList extends JList<MyShape> {

	private static final long serialVersionUID = 1251828228913881094L;

	private static MyShape[] s = new MyShape[5];

	public ShapeList() {
		super(s);
	}
}
