package lab3.Exercise1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import lab3.Exercise1.matrix.TransformationMatrix;

public class Main {

	static int TEMP_MIN_X = -50;
	static int TEMP_MAX_X = 100;
	static int TEMP_MIN_Y = -100;
	static int TEMP_MAX_Y = 50;

	private final static String polygonsFileName = "polygons.txt";

	public static void main(String[] args) {
		int width = Cartesian.getDimmension(TEMP_MIN_X, TEMP_MAX_X);
		int height = Cartesian.getDimmension(TEMP_MIN_Y, TEMP_MAX_Y);
		Cartesian cartesian = new Cartesian(width, height);
		cartesian.drawPolygons(loadPolygonsFromFile());
		cartesian.saveToFile();

		TransformationMatrix mat = new TransformationMatrix();
		mat.addMove(5, 6);
		mat.addScale(-7, 3);
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
			System.out.println(e);
			System.out.println("Error, File stored in " + file.getAbsolutePath() + " can't be loaded.");
		} catch (WrongNumberCoordinates e) {
			System.out.println("Error, File stored in " + file.getAbsolutePath() + " has wrong number of coordinates.");
		}
		return new CartesianPolygon[0];
	}

}
