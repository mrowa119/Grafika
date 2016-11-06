package lab3.Exercise1.matrix;

import java.awt.Point;
import java.util.Arrays;

public class TransformationMatrix {
	protected double[][] transformationMatrix = new double[3][3];

	public TransformationMatrix() {
		transformationMatrix[0][0] = 1;
		transformationMatrix[1][1] = 1;
		transformationMatrix[2][2] = 1;
	}

	public TransformationMatrix(TransformationMatrix matrixToCopy) {
		for (int i = 0; i < transformationMatrix.length; i++) {
			for (int j = 0; j < transformationMatrix[i].length; j++) {
				transformationMatrix[i][j] = matrixToCopy.getValue(i, j);
			}
		}
	}

	private double getValue(int i, int j) {
		return transformationMatrix[i][j];
	}

	public void addMove(double x, double y) {
		MoveMatrix moveMatrix = new MoveMatrix(x, y);
		multipleMatrix(moveMatrix);
	}

	public void addScale(double x, double y) {
		ScaleMatrix scaleMatrix = new ScaleMatrix(x, y);
		multipleMatrix(scaleMatrix);
	}

	public void addRotation(double degrees) {
		degrees %= 360;
		double radians = Math.toRadians(degrees);
		System.out.println(radians);
		RotationMatrix rotationMatrix = new RotationMatrix(radians);
		System.out.println(this);
		System.out.println(rotationMatrix);
		multipleMatrix(rotationMatrix);
		System.out.println(this);
	}

	private void multipleMatrix(TransformationMatrix b) {
		TransformationMatrix a = new TransformationMatrix(this);
		for (int i = 0; i < transformationMatrix.length; i++) {
			for (int j = 0; j < transformationMatrix[i].length; j++) {
				double tmp = 0;
				for (int m = 0; m < transformationMatrix[i].length; m++) {
					tmp += a.getValue(i, m) * b.getValue(m, j);
				}
				transformationMatrix[i][j] = tmp;
			}
		}

	}

	public String toString() {
		String result = "";
		for (int i = 0; i < transformationMatrix.length; i++) {
			result += Arrays.toString(transformationMatrix[i]);
		}
		return result;
	}

	public Point getTransformedPoint(Point point) {
		int[] a = new int[] { (int) point.getX(), (int) point.getY(), 1 };
		int[] result = new int[3];
		for (int i = 0; i < transformationMatrix[0].length; i++) {
			int tmp = 0;
			for (int j = 0; j < a.length; j++) {
				tmp += a[j] * getValue(j, i);
			}
			result[i] = tmp;
		}
		return new Point(result[0], result[1]);
	}

	public void doTransformation(String[] transformation) {
		if (transformation[0].equals("move")) {
			addMove(Integer.parseInt(transformation[1]), Integer.parseInt(transformation[2]));
		} else if (transformation[0].equals("scale")) {
			addScale(Integer.parseInt(transformation[1]), Integer.parseInt(transformation[2]));
		} else if (transformation[0].equals("rotation")) {
			addRotation(Double.parseDouble(transformation[1]));
		}
	}

}
