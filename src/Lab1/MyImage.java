package Lab1;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class MyImage implements Processable{
	// Rozdzielczosc
	final int xRes = 500;
	final int yRes = 1000;

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
	
	protected double getDistanceToCenter(int i, int j) {
		return Math.sqrt(Math.pow((i - yC), 2) + Math.pow(j - xC, 2));
	}
	
	protected void renderAndSave() {
		for (int i = 0; i < yRes; i++) {
			for (int j = 0; j < xRes; j++) {
				processImage(i, j);
			}
		}
		saveImage();
	}
}
