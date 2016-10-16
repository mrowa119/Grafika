package lab1;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class MyImage implements Processable {
	// Rozdzielczosc
	final int xRes = 500;
	final int yRes = 500;

	// Wspó³rzêdne œrodka
	final int xC = xRes / 2;
	final int yC = yRes / 2;

	// Inicjalizacja obrazka
	BufferedImage image = new BufferedImage(xRes, yRes, BufferedImage.TYPE_INT_RGB);

	// Warotœci pliku wyjœciowego
	final String outputFileName = "output";
	final String outputFileExtension = "bmp";
	final String outputFileFormat = "bmp";

	protected void saveImage() {
		try {
			File outputFile = new File(outputFileName + "." + outputFileExtension);
			ImageIO.write(image, outputFileFormat, outputFile);
			System.out.println("Succes. Image stored in " + outputFile.getAbsolutePath());
		} catch (IOException e) {
			System.out.println("Image cannot be stored");
		}
	}

	protected void setColour(int i, int j, int color) {
		image.setRGB(j, i, color);
	}

	protected double getDistanceToCenter(int i, int j) {
		return getDistanceToPoint(i, j, xC, yC);
	}

	protected double getDistanceToPoint(int i, int j, int x, int y) {
		return Math.sqrt(Math.pow((i - y), 2) + Math.pow(j - x, 2));
	}

	protected void renderAndSave() {
		for (int i = 0; i < yRes; i++) {
			for (int j = 0; j < xRes; j++) {
				processImage(i, j);
			}
		}
		saveImage();
	}

	protected BufferedImage render() {
		for (int i = 0; i < yRes; i++) {
			for (int j = 0; j < xRes; j++) {
				processImage(i, j);
			}
		}
		return image;
	}
}
