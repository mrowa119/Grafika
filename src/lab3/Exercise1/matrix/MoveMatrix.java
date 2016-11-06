package lab3.Exercise1.matrix;

public class MoveMatrix extends TransformationMatrix {
	public MoveMatrix(double x, double y) {
		super();
		transformationMatrix[2][0] = x;
		transformationMatrix[2][1] = y;
	}
}
