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
		int[] a = new int[]{(int) point.getX(), (int) point.getY(), 1};
		int[] result = new int[3];
		for(int i=0;i<transformationMatrix[0].length;i++){
			int tmp = 0;
			for(int j=0;j<a.length;j++){
				tmp+=a[j]*getValue(j, i);
			}
			result[i]=tmp;
		}
		System.out.println(point.getX()+"\t"+point.getY()+"\t"+Arrays.toString(result));
		return new Point(result[0], result[1]);
	}

}
