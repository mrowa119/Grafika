package lab3.Exercise4;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import lab3.Exercise4.matrix.TransformationMatrix;

public class Main {
	
	final static String RESOURCE_PREFIX = "res\\l3_e4\\";
	
	private final static String polygonsFileName = RESOURCE_PREFIX + "polygons.txt";
	private final static String transformationFileName = RESOURCE_PREFIX + "transformation.txt";

	public static void main(String[] args) {

		TransformationMatrix transformationMatrix = crateMatrixBasedOnFile();

		CartesianPolygon[] primaryPolygons = loadPolygonsFromFile();
		CartesianPolygon[] newPolygon = calculateNewPolygons(transformationMatrix, primaryPolygons);

		Cartesian cartesian = creantCartesianBoard(primaryPolygons, newPolygon);
		cartesian.drawPolygons(primaryPolygons, Color.RED);
		cartesian.drawPolygons(newPolygon, Color.BLUE);
		cartesian.saveToFile();

	}

	private static CartesianPolygon[] calculateNewPolygons(TransformationMatrix transformationMatrix,
			CartesianPolygon[] primaryPolygons) {
		CartesianPolygon[] newPolygon = new CartesianPolygon[primaryPolygons.length];
		for (int i = 0; i < primaryPolygons.length; i++) {
			newPolygon[i] = creatTransforatedPolygon(primaryPolygons[i], transformationMatrix);
		}
		return newPolygon;
	}

	private static TransformationMatrix crateMatrixBasedOnFile() {
		TransformationMatrix transformationMatrix = new TransformationMatrix();
		File file = new File(transformationFileName);
		try {
			Scanner in = new Scanner(file);
			int transformationLength = Integer.parseInt(in.nextLine());
			for (int i = 0; i < transformationLength; i++) {
				transformationMatrix.doTransformation(in.nextLine().split(" "));
			}
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error, File stored in " + file.getAbsolutePath() + " can't be loaded.");
		}
		return transformationMatrix;
	}

	private static CartesianPolygon creatTransforatedPolygon(CartesianPolygon cartesianPolygon,
			TransformationMatrix transformationMatrix) {
		return new CartesianPolygon(cartesianPolygon, transformationMatrix);
	}

	private static CartesianPolygon[] loadPolygonsFromFile() {
		File file = new File(polygonsFileName);
		try {
			Scanner in = new Scanner(file);
			int polygonsLength = Integer.parseInt(in.nextLine());
			CartesianPolygon[] polygons = new CartesianPolygon[polygonsLength];
			for (int i = 0; i < polygonsLength; i++) {
				polygons[i] = new CartesianPolygon();
				String coordinates[] = in.nextLine().split(" ");
				polygons[i].addPoints(coordinates);
			}
			in.close();
			return polygons;
		} catch (FileNotFoundException e) {
			System.out.println("Error, File stored in " + file.getAbsolutePath() + " can't be loaded.");
		} catch (WrongNumberCoordinates e) {
			System.out.println("Error, File stored in " + file.getAbsolutePath() + " has wrong number of coordinates.");
		}
		return new CartesianPolygon[0];
	}

	private static Cartesian creantCartesianBoard(CartesianPolygon[] primaryPolygons, CartesianPolygon[] newPolygon) {
		int minX = Math.min(getMinXFromPolygons(primaryPolygons), getMinXFromPolygons(newPolygon));
		int maxX = Math.max(getMaxXFromPolygons(primaryPolygons), getMaxXFromPolygons(newPolygon));
		int minY = Math.min(getMinYFromPolygons(primaryPolygons), getMinYFromPolygons(newPolygon));
		int maxY = Math.max(getMaxYFromPolygons(primaryPolygons), getMaxYFromPolygons(newPolygon));
		int width = Cartesian.getDimmension(minX, maxX);
		int height = Cartesian.getDimmension(minY, maxY);
		Cartesian cartesian = new Cartesian(width, height);
		return cartesian;
	}

	private static int getMaxYFromPolygons(CartesianPolygon[] polygons) {
		int[] y = new int[polygons.length];
		for (int i = 0; i < polygons.length; i++) {
			y[i] = polygons[i].getMaxY();
		}
		return Tools.getMax(y);
	}

	private static int getMinYFromPolygons(CartesianPolygon[] polygons) {
		int[] y = new int[polygons.length];
		for (int i = 0; i < polygons.length; i++) {
			y[i] = polygons[i].getMinY();
		}
		return Tools.getMin(y);
	}

	private static int getMaxXFromPolygons(CartesianPolygon[] polygons) {
		int[] x = new int[polygons.length];
		for (int i = 0; i < polygons.length; i++) {
			x[i] = polygons[i].getMaxX();
		}
		return Tools.getMax(x);
	}

	private static int getMinXFromPolygons(CartesianPolygon[] polygons) {
		int[] x = new int[polygons.length];
		for (int i = 0; i < polygons.length; i++) {
			x[i] = polygons[i].getMinX();
		}
		return Tools.getMin(x);
	}

}
