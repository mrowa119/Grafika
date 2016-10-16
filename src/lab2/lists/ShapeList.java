package lab2.lists;

import javax.swing.JList;

import lab2.shapes.Shape;

public class ShapeList extends JList<Shape> {

	private static final long serialVersionUID = 1251828228913881094L;
	
	private static Shape[] s = new Shape[5];
	{
	for(int i=0;i<s.length;i++){
		s[i] = new Shape();
	}
	}

	public ShapeList() {
		super(s);
	}
}
