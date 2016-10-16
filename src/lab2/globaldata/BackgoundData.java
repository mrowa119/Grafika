package lab2.globaldata;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BackgoundData {
	public static Image BACKGORUND_IMAGE;
	public static JPanel IMAGE_PANEL;

	public static void loadAndUpdateBackgroundImageFromFile(File imageFile) {
		loadBackgounImageFromFile(imageFile);
		updateImage();
	}

	private static void updateImage() {
		IMAGE_PANEL.repaint();
	}

	private static void loadBackgounImageFromFile(File imageFile) {
		try {
			BackgoundData.BACKGORUND_IMAGE = ImageIO.read(imageFile);
		} catch (IOException e) {
			System.out.println("Image cannot be laoded");
		}
	}

}
