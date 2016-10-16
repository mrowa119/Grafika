package lab1;

public class Exercise2b extends LoadedImage {

	// Szerokoœæ lini kratki
	final int lineWidth = 50;

	// Odleg³oœæ pomiêdzy œrodkami lini
	final int distanceBetweenMiddleOfLinesX = 3 * lineWidth;
	final int distanceBetweenMiddleOfLinesY = 2 * lineWidth;

	// Kolory
	final int figureColor = Tools.int2RGB(0, 0, 0);

	@Override
	public void processImage(int i, int j) {
		int distanceFromCenterX = Math.abs(xC - j);
		int distanceFromCenterY = Math.abs(yC - i);

		if (distanceFromAbsoluteCenterX(distanceFromCenterX) > distanceFromMiddleLine()
				&& distanceFromAbsoluteCenterY(distanceFromCenterY) > distanceFromMiddleLine()) {
			setColour(i, j, getColour(i, j));
		} else {
			setColour(i, j, figureColor);
		}

	}

	private int distanceFromMiddleLine() {
		return lineWidth / 2;
	}

	private int distanceFromAbsoluteCenterY(int distanceFromCenterY) {
		return Math.abs(distanceFromCenterY % distanceBetweenMiddleOfLinesY - (distanceBetweenMiddleOfLinesY / 2));
	}

	private int distanceFromAbsoluteCenterX(int distanceFromCenterX) {
		return Math.abs(distanceFromCenterX % distanceBetweenMiddleOfLinesX - (distanceBetweenMiddleOfLinesX / 2));
	}

	public static void main(String[] args) {
		new Exercise2b().renderAndSave();
	}

}
