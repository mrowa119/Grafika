package lab2.lists;

import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import lab2.globaldata.BackgoundData;
import lab2.shapes.MyShape;

public class ShapeList extends JList<MyShape> {

	private static final long serialVersionUID = 1251828228913881094L;

	public ShapeList() {
		super(BackgoundData.SHAPES_LIST);
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListSelectionModel listSelectionModel = getSelectionModel();
		listSelectionModel.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting()) {
					BackgoundData.setSelectedShapeId(getSelectedIndex());
				}
			}
		});
	}
}
