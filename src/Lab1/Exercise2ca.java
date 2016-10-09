package Lab1;

public class Exercise2ca extends LoadedImage implements Processable {

	// Kolory
	final int figureColor = Tools.int2RGB(0, 0, 0);

	// Rozmial pola
	final int fieldSize = 100;

	@Override
	public void processImage(int i, int j) {
		int distanceFromSideCenterElementX = Math.abs(xC - j) + fieldSize / 2;
		int distanceFromSideCenterElementY = Math.abs(yC - i) + fieldSize / 2;

		int horisontalElementDiffCount = distanceFromSideCenterElementX / fieldSize;
		int verticalElementDiffCount = distanceFromSideCenterElementY / fieldSize;

		if ((horisontalElementDiffCount + verticalElementDiffCount) % 2 == 0) {
			setColour(i, j, figureColor);
		} else {
			setColour(i, j, getColour(i, j));
		}
	}

	public static void main(String[] args) {
		new Exercise2ca().renderAndSave();
	}

}
