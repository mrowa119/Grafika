package lab3.Exercise6.Interpolations;

import java.awt.Color;

public class BipolarInterpolation extends Interpolation {

	@Override
	public int getRedColour(double[] sourcePoint, int[] sourceColours) {
		int[] sourceRedColour = new int[sourceColours.length];
		for (int i = 0; i < sourceRedColour.length; i++) {
			sourceRedColour[i] = new Color(sourceColours[i]).getRed();
		}
		return getOneColour(sourcePoint, sourceRedColour);
	}

	@Override
	public int getGreenColour(double[] sourcePoint, int[] sourceColours) {
		int[] sourceRedColour = new int[sourceColours.length];
		for (int i = 0; i < sourceRedColour.length; i++) {
			sourceRedColour[i] = new Color(sourceColours[i]).getGreen();
		}
		return getOneColour(sourcePoint, sourceRedColour);
	}

	@Override
	public int getBlueColour(double[] sourcePoint, int[] sourceColours) {
		int[] sourceRedColour = new int[sourceColours.length];
		for (int i = 0; i < sourceRedColour.length; i++) {
			sourceRedColour[i] = new Color(sourceColours[i]).getBlue();
		}
		return getOneColour(sourcePoint, sourceRedColour);
	}

	private int getOneColour(double[] sourcePoint, int[] sourceOneColour) {
		double a = interpolationFactor(sourcePoint[0]);
		double b = interpolationFactor(sourcePoint[1]);
		double tempColourA = sourceOneColour[0] * (1 - a) + sourceOneColour[1] * a;
		double tempColourB = sourceOneColour[2] * (1 - a) + sourceOneColour[3] * a;
		double resultColour = tempColourA * (1-b) + tempColourB * b;
		return (int) Math.round(resultColour);
	}

	protected double interpolationFactor(double point) {
		return point - (int) point;
	}

}
