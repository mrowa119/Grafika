package lab3.Exercise6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

import lab3.Exercise6.exceptions.MatrixDetIs0;

public class TransformationMatrix {
	protected double[][] transformationMatrix = new double[3][3];

	public TransformationMatrix() {

	}

	public TransformationMatrix(TransformationMatrix matrixToCopy) {
		for (int i = 0; i < transformationMatrix.length; i++) {
			for (int j = 0; j < transformationMatrix[i].length; j++) {
				transformationMatrix[i][j] = matrixToCopy.getValue(i, j);
			}
		}
	}

	public TransformationMatrix(double[][] matrix) {
		for (int i = 0; i < transformationMatrix.length; i++) {
			for (int j = 0; j < transformationMatrix[i].length; j++) {
				transformationMatrix[i][j] = matrix[i][j];
			}
		}
	}

	public TransformationMatrix(String inputMatrixFileName) {
		File file = new File(inputMatrixFileName);
		try {
			Scanner in = new Scanner(file);
			for (int i = 0; i < 3; i++) {
				String row[] = in.nextLine().split(" ");
				for (int j = 0; j < 3; j++) {
					transformationMatrix[i][j] = Double.parseDouble(row[j]);
				}
			}
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error, File stored in " + file.getAbsolutePath() + " can't be loaded.");
		} catch (ArrayIndexOutOfBoundsException | NoSuchElementException e) {
			System.out.println("Error, File stored in " + file.getAbsolutePath() + " has wrong matrix.");
		}
	}

	public TransformationMatrix getInverted() throws MatrixDetIs0 {
		if (getDet() != 0) {
			Macierz macierz = new Macierz(transformationMatrix);
			return new TransformationMatrix(macierz.wyznaczMacierzOdwrotna().getTablice());
		}
		throw new MatrixDetIs0();
	}

	private double getDet() {
		double[][] a = transformationMatrix;
		double x = a[0][0] * a[1][1] * a[2][2] + a[0][1] * a[1][2] * a[2][0] + a[0][2] * a[1][0] * a[2][1];
		double y = a[0][2] * a[1][1] * a[2][0] + a[0][0] * a[1][2] * a[2][1] + a[0][1] * a[1][0] * a[2][2];
		return x - y;
	}

	private double getValue(int i, int j) {
		return transformationMatrix[i][j];
	}
	
	public double[] getTransformedPoint(double[] point) {
		double[] a = new double[]{point[0], point[1], 1.0};
		double[] result = new double[3];
		for (int i = 0; i < transformationMatrix[0].length; i++) {
			double tmp = 0;
			for (int j = 0; j < a.length; j++) {
				tmp += a[j] * getValue(j, i);
			}
			result[i] = tmp;
		}
		return result;
	}

	public String toString() {
		String result = "";
		for (int i = 0; i < transformationMatrix.length; i++) {
			result += Arrays.toString(transformationMatrix[i]);
		}
		return result;
	}

}
