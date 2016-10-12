package Lab1;

public class Exercise2a extends LoadedImage implements Processable {

	// Kolory
	int figureColor = Tools.int2RGB(0, 0, 0);
	int backColor = Tools.int2RGB(255, 255, 255);

	// Szerokosc pierscienia
	final int ringWidth = 20;
	final int gradientWidth = 60;

	@Override
	public void processImage(int i, int j) {
		double radius;

		radius = getDistanceToCenter(i, j);

		setColour(i, j, getRingColour(radius, i, j));
	}

	private int getRingColour(double radius, int i, int j) {
		int absoluteRadius = (int) (radius % (2 * (ringWidth + gradientWidth)));
		if (isFigure(absoluteRadius)) {
			return figureColor;
		} else if (isFirstGradiend(absoluteRadius)) {
			int coursorPositionInGradient = absoluteRadius - ringWidth;
			return getGradientFieldColour(gradientWidth - coursorPositionInGradient, getColour(i, j));
		} else if (isBackround(absoluteRadius)) {
			return getColour(i, j);
		} else {
			int coursorPositionInGradient = absoluteRadius - 2 * ringWidth - gradientWidth;
			return getGradientFieldColour(coursorPositionInGradient, getColour(i, j));
		}
	}

	private int getGradientFieldColour(int coursorPositionInGradient, int backgroundColor) {
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

	private boolean isFirstGradiend(int absoluteRadius) {
		return absoluteRadius < (ringWidth + gradientWidth);
	}

	private boolean isBackround(int absoluteRadius) {
		return absoluteRadius < (2 * ringWidth + gradientWidth);
	}

	private boolean isFigure(int absoluteRadius) {
		return absoluteRadius < ringWidth;
	}

	public static void main(String[] args) {
		new Exercise2a().renderAndSave();
	}
}
