package Lab1;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Exercise1a {

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
	final int ringWidth = 10;
	final int gradientWidth = 60;

	final String outputFileName = "exercise1a";
	final String outputFileExtension = "bmp";
	final String outputFileFormat = "bmp";

	// Inicjalizacja obrazka
	BufferedImage image = new BufferedImage(xRes, yRes, BufferedImage.TYPE_INT_RGB);

	public void processImage() {
		for (int i = 0; i < yRes; i++) {
			for (int j = 0; j < xRes; j++) {
				double radius;

				radius = getDistanceToCenter(i, j);

				setColour(i, j, getRingColour(radius));
			}
		}
		saveImage();
		
	}

	private void saveImage() {
		try {
			File outputFile = new File(outputFileName+"."+outputFileExtension);
			ImageIO.write(image, outputFileFormat, outputFile);
			System.out.println("Succes. Image stored in "+outputFile.getAbsolutePath());
		} catch (IOException e) {
			System.out.println("Image cannot be stored");
		}
	}

	private void setColour(int i, int j, int color) {
		image.setRGB(j, i, color);
	}

	private int getRingColour(double radius) {
		int apsoluteRadius = (int) (radius%(2*ringWidth+gradientWidth));
		if(isFigure(apsoluteRadius)){
			return figureColor;
		} else if (isBackround(apsoluteRadius)){
			return backgroundColor;
		} else {
			int coursorPositionInGradient = apsoluteRadius-2*ringWidth;
			return getGradientFieldColour(coursorPositionInGradient);
		}
	}

	private int getGradientFieldColour(int coursorPositionInGradient) {
		int figureRed = RGB2red(figureColor);
		int figureGreen = RGB2green(figureColor);
		int figureBlue = RGB2blue(figureColor);
		int backgroundRed = RGB2red(backgroundColor);
		int backgroundGreen = RGB2green(backgroundColor);
		int backgroundBlue = RGB2blue(backgroundColor);
		
		int gradientRed = backgroundRed + coursorPositionInGradient *((figureRed-backgroundRed)/(gradientWidth+1));
		int gradientGreen = backgroundGreen + coursorPositionInGradient *((figureGreen-backgroundGreen)/(gradientWidth+1));
		int gradientBlue = backgroundBlue+ coursorPositionInGradient *((figureBlue-backgroundBlue)/(gradientWidth+1));

		return int2RGB(gradientRed, gradientGreen, gradientBlue);
	}

	private boolean isBackround(int apsoluteRadius) {
		return apsoluteRadius<2*ringWidth;
	}

	private boolean isFigure(int apsoluteRadius) {
		return apsoluteRadius<ringWidth;
	}

	private double getDistanceToCenter(int i, int j) {
		return Math.sqrt(Math.pow((i - yC), 2) + Math.pow(j - xC, 2));
	}

	static int int2RGB(int red, int green, int blue) {
		red = red % 256;
		green %= 256;
		blue %= 256;
		return (red << 16) + (green << 8) + blue;
	}
	
	static int RGB2red(int rgb){
		return rgb >> 16;
	}
	
	static int RGB2green(int rgb){
		return (rgb >> 8) % 256;
	}
	
	static int RGB2blue(int rgb){
		return rgb & 0x000000FF;
	}
	
	public static void main(String[] args) {
		new Exercise1a().processImage();
	}
}
