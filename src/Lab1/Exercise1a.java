package Lab1;

public class Exercise1a extends MyImage{

	// Kolory
	int figureColor = Tools.int2RGB(0, 0, 0);
	int backgroundColor = Tools.int2RGB(255, 255, 255);

	// Szerokosc pierscienia
	final int ringWidth = 10;
	final int gradientWidth = 60;

	public void processImage() {
		for (int i = 0; i < yRes; i++) {
			for (int j = 0; j < xRes; j++) {
				double radius;

				radius = getDistanceToCenter(i, j);

				setColour(i, j, getRingColour(radius));
			}
		}
		saveImage();

	}

	private void setColour(int i, int j, int color) {
		image.setRGB(j, i, color);
	}

	private int getRingColour(double radius) {
		int apsoluteRadius = (int) (radius % (2 * ringWidth + gradientWidth));
		if (isFigure(apsoluteRadius)) {
			return figureColor;
		} else if (isBackround(apsoluteRadius)) {
			return backgroundColor;
		} else {
			int coursorPositionInGradient = apsoluteRadius - 2 * ringWidth;
			return getGradientFieldColour(coursorPositionInGradient);
		}
	}

	private int getGradientFieldColour(int coursorPositionInGradient) {
		int figureRed = Tools.RGB2red(figureColor);
		int figureGreen = Tools.RGB2green(figureColor);
		int figureBlue = Tools.RGB2blue(figureColor);
		int backgroundRed = Tools.RGB2red(backgroundColor);
		int backgroundGreen = Tools.RGB2green(backgroundColor);
		int backgroundBlue = Tools.RGB2blue(backgroundColor);

		int gradientRed = backgroundRed
				+ coursorPositionInGradient * ((figureRed - backgroundRed) / (gradientWidth + 1));
		int gradientGreen = backgroundGreen
				+ coursorPositionInGradient * ((figureGreen - backgroundGreen) / (gradientWidth + 1));
		int gradientBlue = backgroundBlue
				+ coursorPositionInGradient * ((figureBlue - backgroundBlue) / (gradientWidth + 1));

		return Tools.int2RGB(gradientRed, gradientGreen, gradientBlue);
	}

	private boolean isBackround(int apsoluteRadius) {
		return apsoluteRadius < 2 * ringWidth;
	}

	private boolean isFigure(int apsoluteRadius) {
		return apsoluteRadius < ringWidth;
	}

	public static void main(String[] args) {
		new Exercise1a().processImage();
	}
}
