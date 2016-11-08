package lab3.Exercise6;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import lab3.Exercise6.Interpolations.BipolarInterpolation;
import lab3.Exercise6.Interpolations.Interpolation;
import lab3.Exercise6.exceptions.MatrixDetIs0;

public class Main {

	public final static String RESOURCE_PREFIX = "res\\l3_e6\\";

	private final static String INPUT_IMAGE_FILE_NAME = RESOURCE_PREFIX + "source.png";

	private final static String INPUT_MATRIX_FILE_NAME = RESOURCE_PREFIX + "transformation_matrix.txt";

	private final static int OUTPUT_WIDTH = 1000;
	private final static int OUTPUT_HEIGHT = 1000;

	private final static String OUTPUT_FILE_NAME = RESOURCE_PREFIX + "output.png";
	private final static String OUTPUT_FILE_FORMAT = "png";

	private final static TransformationMatrix TRANSFORMATION_MATRIX = new TransformationMatrix(INPUT_MATRIX_FILE_NAME);

	private final static Interpolation INTERPOLATION = new BipolarInterpolation();

	public static void main(String[] args) {
		BufferedImage source = loadImageFromFile(INPUT_IMAGE_FILE_NAME);
		BufferedImage outputImage = new BufferedImage(OUTPUT_WIDTH, OUTPUT_HEIGHT, BufferedImage.TYPE_INT_ARGB);
		try {
			TransformationMatrix invertedMatrix = TRANSFORMATION_MATRIX.getInverted();

			for (int i = 0; i < OUTPUT_HEIGHT; i++) {
				for (int j = 0; j < OUTPUT_WIDTH; j++) {
					double[] sourcePoint = invertedMatrix.getTransformedPoint(new double[] { i, j });
					int colour = 0;
					try {
						colour = getColor(source, sourcePoint);
					} catch (ArrayIndexOutOfBoundsException e) {
						colour = new Color(0, 0, 0).getRGB();
					}
					outputImage.setRGB(i, j, colour);
				}
			}
		} catch (MatrixDetIs0 e) {
			System.out.println("Wyznacznik macierzy wynosi 0 nie mo¿na obliczyæ macierzy odwortnej");
		}

		saveImageToFile(outputImage, OUTPUT_FILE_NAME);
	}

	private static int getColor(BufferedImage source, double[] sourcePoint) {
		if (sourcePoint[0] < 0 || sourcePoint[1] < 0) {
			throw new ArrayIndexOutOfBoundsException();
		}
		int[] sourceColours = new int[] { source.getRGB((int) sourcePoint[0], (int) sourcePoint[1]),
				source.getRGB((int) sourcePoint[0] + 1, (int) sourcePoint[1]),
				source.getRGB((int) sourcePoint[0], (int) sourcePoint[1] + 1),
				source.getRGB((int) sourcePoint[0] + 1, (int) sourcePoint[1] + 1) };

		int finalRed = INTERPOLATION.getRedColour(sourcePoint, sourceColours);
		int finalGreen = INTERPOLATION.getGreenColour(sourcePoint, sourceColours);
		int finalBlue = INTERPOLATION.getBlueColour(sourcePoint, sourceColours);
		return new Color(finalRed, finalGreen, finalBlue).getRGB();
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
