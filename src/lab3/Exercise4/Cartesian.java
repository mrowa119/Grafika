package lab3.Exercise4;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Cartesian extends BufferedImage {

	private static final String OUTPUT_FILE_NAME = Main.RESOURCE_PREFIX + "Cartesian.bmp";
	private static final String OUTPUT_FILE_FORMAT = "bmp";

	private static final Color BACKGROUND_COLOR = Color.white;
	private static final Color AXIS_COLOR = Color.BLACK;

	public Cartesian(int width, int height) {
		super(width, height, BufferedImage.TYPE_INT_RGB);
		setBacground(BACKGROUND_COLOR);
		createAxisX();
		createAxisY();
	}

	private void createAxisX() {
		int middleX = getHeight() / 2;
		for (int i = 0; i < getWidth(); i++) {
			setColour(i, middleX, AXIS_COLOR);
		}
	}

	private void createAxisY() {
		int middleY = getWidth() / 2;
		for (int i = 0; i < getHeight(); i++) {
			setColour(middleY, i, AXIS_COLOR);
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
			File outputFile = new File(OUTPUT_FILE_NAME);
			ImageIO.write(new FinalCartesian(this), OUTPUT_FILE_FORMAT, outputFile);
			System.out.println("Succes. Image stored in " + outputFile.getAbsolutePath());
		} catch (IOException e) {
			System.out.println("Image cannot be stored");
		}
	}

	public static int getDimmension(int min, int max) {
		return 2 * Math.max(Math.abs(min), Math.abs(max)) + 11;
	}

	public void drawPolygons(CartesianPolygon[] polygons, Color color) {
		for (int i = 0; i < polygons.length; i++) {
			drawPolygon(polygons[i], color);
		}
	}

	private void drawPolygon(CartesianPolygon polygon, Color color) {
		Graphics2D g2 = createGraphics();
		g2.setColor(color);
		polygon.updatePoints(getMiddlePoint());
		g2.draw(polygon);
		g2.dispose();
	}

	private Point getMiddlePoint() {
		return new Point(getWidth() / 2, getHeight() / 2);
	}
}
