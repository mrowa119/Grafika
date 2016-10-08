package Lab1;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Example {

	// Kolory
	int figureColor = int2RGB(0, 0, 0);
	int backgroundColor = int2RGB(255, 255, 255);

	// Rozdzielczosc
	final int xRes = 500;
	final int yRes = 500;

	// Wspó³rzêdne œrodka
	final int xC = xRes / 2;
	final int yC = yRes / 2;

	// Szerokosc pierscienia
	final int w = 10;

	final String outputFileName = "example";
	final String outputFileExtension = "bmp";
	final String outputFileFormat = "bmp";

	// Inicjalizacja obrazka
	BufferedImage image = new BufferedImage(xRes, yRes, BufferedImage.TYPE_INT_RGB);

	public void processImage() {
		for (int i = 0; i < yRes; i++) {
			for (int j = 0; j < xRes; j++) {
				double d;
				int r;

				d = getDistanceToCenter(i, j);
				r = getRingIndex(d);

				if (isFigure(r)) {
					System.out.println("Fig");
					setFigureColour(i, j);
				} else {
					System.out.println("Bac");
					setBackgroudnColor(i, j);
				}
			}
		}
		try {
			File outputFile = new File(outputFileName+"."+outputFileExtension);
			ImageIO.write(image, outputFileFormat, outputFile);
			System.out.println("Succes. Image stored in "+outputFile.getAbsolutePath());
		} catch (IOException e) {
			System.out.println("Image cannot be stored");
		}
		
	}

	static int int2RGB(int red, int green, int blue) {
		red = red % 256;
		green %= 256;
		blue %= 256;
		return (red << 16) + (green << 8) + blue;
	}

	private void setBackgroudnColor(int i, int j) {
		setColour(i, j, backgroundColor);
	}

	private void setColour(int i, int j, int color) {
		image.setRGB(j, i, color);
	}

	private void setFigureColour(int i, int j) {
		setColour(i, j, figureColor);
	}

	private boolean isFigure(int r) {
		return r % 2 == 0;
	}

	private int getRingIndex(double d) {
		return (int) d / w;
	}

	private double getDistanceToCenter(int i, int j) {
		return Math.sqrt(Math.pow((i - yC), 2) + Math.pow(j - xC, 2));
	}

	
	
	public static void main(String[] args) {
		new Example().processImage();
	}
}
