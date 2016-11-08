package lab3.Exercise6;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Main {
	
	final static String RESOURCE_PREFIX = "res\\l3_e6\\";

	final static String INPUT_IMAGE_FILE_NAME = RESOURCE_PREFIX + "source.png";
	final static String INPUT_MATRIX_FILE_NAME = RESOURCE_PREFIX + "transformation_matrix.txt";
	
	final static String OUTPUT_FILE_NAME = RESOURCE_PREFIX + "output.png";
	final static String OUTPUT_FILE_FORMAT = "png";
	
	final static TransformationMatrix TRANSFORMATION_MATRIX = new TransformationMatrix(INPUT_MATRIX_FILE_NAME);
	
	
	public static void main(String[] args) {
		BufferedImage source = loadImageFromFile(INPUT_IMAGE_FILE_NAME);
		
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
