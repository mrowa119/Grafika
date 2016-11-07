package lab3.Exercise6;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Main {

	final static String INPUT_FILE_NAME = "source.png";
	final static String OUTPUT_FILE_NAME = "output.png";
	final static String OUTPUT_FILE_FORMAT = "png";
	
	public static void main(String[] args) {
		BufferedImage source = loadImageFromFile(INPUT_FILE_NAME);
		saveImageToFile(source, OUTPUT_FILE_NAME);
	}

	
	
	
	private static void saveImageToFile(BufferedImage image, String outputFileName) {
		try {
			File outputFile = new File(outputFileName);
			ImageIO.write(image, OUTPUT_FILE_FORMAT, outputFile);
			System.out.println("Succes. Image stored in " + outputFile.getAbsolutePath());
		} catch (IOException e) {
			System.out.println("Image cannot be stored");
		}
	}

	private static BufferedImage loadImageFromFile(String inputFileName) {
		File inputFile = new File(inputFileName);
		try {
			return ImageIO.read(inputFile);
		} catch (IOException e) {
			System.out.println("Error, File stored in " + inputFile.getAbsolutePath() + " can't be loaded.");
		}
		return null;
	}
	
}
