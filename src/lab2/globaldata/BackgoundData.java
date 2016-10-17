package lab2.globaldata;

import java.awt.Image;
import java.awt.Shape;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import lab2.shapes.MyShape;

public class BackgoundData {
	public static Image BACKGORUND_IMAGE;
	public static JPanel IMAGE_PANEL;
	public static ArrayList<MyShape> shapesList = new ArrayList<MyShape>();

	public static void loadAndUpdateBackgroundImageFromFile(File imageFile) {
		loadBackgounImageFromFile(imageFile);
		updateImage();
	}

	private static void updateImage() {
		IMAGE_PANEL.repaint();
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
	
	public static void addShape(Shape shape){
		shapesList.add(new MyShape(CoursorData.RED_COURSOR, CoursorData.GREEN_COURSOR, CoursorData.BLUE_COURSOR, CoursorData.SHAPE_COURSOR, shape));
	}

}
