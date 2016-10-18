package lab2.globaldata;

import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

import lab2.shapes.MyShape;

public class BackgoundData {
	public static Image BACKGORUND_IMAGE;
	public static JPanel IMAGE_PANEL;
	public static DefaultListModel<MyShape> SHAPES_LIST = new DefaultListModel<MyShape>();
	public static int SELECTED_SHAPE_ID = -1;
	public static ListSelectionModel LIST_SELECTION_MODEL;
	public static ArrayList<MyShape> REMOVED_SHAPES = new ArrayList<MyShape>();

	public static void loadAndUpdateBackgroundImageFromFile(File imageFile) {
		loadBackgounImageFromFile(imageFile);
		REMOVED_SHAPES.clear();
		updateImage();
	}

	private static void updateImage() {
		repaint();
	}

	private static void loadBackgounImageFromFile(File imageFile) {
		try {
			BACKGORUND_IMAGE = ImageIO.read(imageFile);
		} catch (IOException e) {
			System.out.println("Image cannot be laoded");
		}
	}

	public static boolean isBackgroundSet() {
		return BACKGORUND_IMAGE != null;
	}

	public static void addShape(Shape shape) {
		SHAPES_LIST.addElement(new MyShape(CoursorData.RED_COURSOR, CoursorData.GREEN_COURSOR, CoursorData.BLUE_COURSOR,
				CoursorData.SHAPE_COURSOR, shape));
	}

	public static void addLoadedShapes(DefaultListModel<MyShape> readObject) {
		for (int i = 0; i < readObject.size(); i++) {
			SHAPES_LIST.addElement(readObject.getElementAt(i));
		}
	}

	public static boolean haveShapes() {
		return !SHAPES_LIST.isEmpty();
	}

	public static void clearList() {
		SHAPES_LIST.clear();
		SELECTED_SHAPE_ID = -1;
		repaint();
	}

	public static void setSelectedShapeId(int selectedShapeId) {
		SELECTED_SHAPE_ID = selectedShapeId;
		repaint();
	}

	private static void repaint() {
		IMAGE_PANEL.repaint();
	}

	public static void unselect() {
		SELECTED_SHAPE_ID = -1;
		LIST_SELECTION_MODEL.clearSelection();
		repaint();
	}

	public static boolean isSelected() {
		return SELECTED_SHAPE_ID > -1;
	}

	public static MyShape getSelectedShape() {
		if (isSelected()) {
			return SHAPES_LIST.get(SELECTED_SHAPE_ID);
		} else {
			return null;
		}
	}

	public static Rectangle2D[] getSelectedShapePoints() {
		if (isSelected()) {
			return getSelectedShape().getPoints();
		} else {
			return null;
		}
	}

	public static void removeShape() {
		REMOVED_SHAPES.add(SHAPES_LIST.get(SELECTED_SHAPE_ID));
		SHAPES_LIST.remove(SELECTED_SHAPE_ID);
		SELECTED_SHAPE_ID = -1;
		repaint();
	}

}
