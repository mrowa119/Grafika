package lab3.Exercise1;

import java.awt.Color;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Cartesian extends BufferedImage {

	private final String outputFileName = "Cartesian.bmp";
	private final String outputFileFormat = "bmp";

	public Cartesian(int width, int height) {
		super(width, height, BufferedImage.TYPE_INT_RGB);
		setBacground(Color.white);
		createAxisX();
		createAxisY();
	}

	private void createAxisX() {
		int middleX = getHeight() / 2;
		for (int i = 0; i < getWidth(); i++) {
			setColour(i, middleX, Color.BLACK);
		}
	}
	
	private void createAxisY() {
		int middleY = getWidth() / 2;
		for (int i = 0; i < getHeight(); i++) {
			setColour(middleY, i, Color.BLACK);
		}
	}

	private void setBacground(Color color) {
		for (int i = 0; i < getWidth(); i++) {
			for (int j = 0; j < getHeight(); j++) {
				setColour(i, j, color);
			}
		}
	}

	private void setColour(int width, int height, Color color) {
		setRGB(width, height, color.getRGB());
	}

	protected void saveToFile() {
		try {
			File outputFile = new File(outputFileName);
			ImageIO.write(this, outputFileFormat, outputFile);
			System.out.println("Succes. Image stored in " + outputFile.getAbsolutePath());
		} catch (IOException e) {
			System.out.println("Image cannot be stored");
		}
	}

	public static int getDimmension(int min, int max) {
		return 2 * Math.max(Math.abs(min), Math.abs(max)) + 1;
	}

	public void drawPolygon(Polygon[] polygons) {
		for(int i=0; i<polygons.length; i++){
			
		}
	}
}
