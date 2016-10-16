package lab1;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class LoadedImage implements Processable {

	// Obraz t�o
	BufferedImage image = loadImage();

	// Rozdzielczosc
	final int xRes = image.getWidth();
	final int yRes = image.getHeight();

	// Wsp�rz�dne �rodka
	final int xC = xRes / 2;
	final int yC = yRes / 2;

	// Warot�ci pliku wyj�ciowego
	final String inputFileName = "input";
	final String inputFileExtension = "jpg";
	final String inputFileFormat = "jpeg";

	// Warot�ci pliku wyj�ciowego
	final String outputFileName = "output2";
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

	protected BufferedImage loadImage() {
		File inputFile = new File(inputFileName + "." + inputFileExtension);
		return loadImageFromFile(inputFile);
	}

	protected BufferedImage loadImageFromFile(File inputFile) {
		try {
			return ImageIO.read(inputFile);
		} catch (IOException e) {
			System.out.println("Image cannot be laoded");
		}
		return null;
	}

	protected void setColour(int i, int j, int color) {
		image.setRGB(j, i, color);
	}

	protected int getColour(int i, int j) {
		return image.getRGB(j, i) & 0x00FFFFFF;
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
