package lab3.Exercise4.matrix;

public class RotationMatrix extends TransformationMatrix {
	public RotationMatrix(double radians) {
		super();
		transformationMatrix[0][0] = Math.cos(radians);
		transformationMatrix[0][1] = Math.sin(radians);
		transformationMatrix[1][0] = -1 * Math.sin(radians);
		transformationMatrix[1][1] = Math.cos(radians);
	}
}
