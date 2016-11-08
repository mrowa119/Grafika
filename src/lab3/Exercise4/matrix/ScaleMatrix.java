package lab3.Exercise4.matrix;

public class ScaleMatrix extends TransformationMatrix {
	public ScaleMatrix(double x, double y) {
		super();
		transformationMatrix[0][0] = x;
		transformationMatrix[1][1] = y;
	}
}
