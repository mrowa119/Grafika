package lab1;

public class Exercise3d extends MyImage implements Processable {

	// Kolory
	final int figureColor = Tools.int2RGB(0, 0, 0);
	final int backgroundColor = Tools.int2RGB(255, 255, 255);

	// Srednica kola
	final int radius = 38;
	final int ringWidth = 6;
	final int virtualSquare = 2 * (radius);
	final int halfVirtualSquare = radius;

	@Override
	public void processImage(int i, int j) {
		int distanceFromCenterX = (int) getDistanceToPoint(i, j, xC, i);
		int distanceFromCenterY = (int) getDistanceToPoint(i, j, j, yC);

		int distanceFromCenterOfVirtualSquareX = Math.abs((distanceFromCenterX % virtualSquare) - halfVirtualSquare);
		int distanceFromCenterOfVirtualSquareY = Math.abs((distanceFromCenterY % virtualSquare) - halfVirtualSquare);

		int distanceFromNearestCenter = getDistanceFromNearestCenter(distanceFromCenterOfVirtualSquareX,
				distanceFromCenterOfVirtualSquareY);

		if ((distanceFromNearestCenter / ringWidth) % 2 == 0) {
			setColour(i, j, figureColor);
		} else {
			setColour(i, j, backgroundColor);
		}
	}

	private int getDistanceFromNearestCenter(int distanceFromCenterOfVirtualSquareX,
			int distanceFromCenterOfVirtualSquareY) {
		return (int) Math.sqrt(
				Math.pow(distanceFromCenterOfVirtualSquareX, 2) + Math.pow(distanceFromCenterOfVirtualSquareY, 2));
	}

	public static void main(String[] args) {
		new Exercise3d().renderAndSave();
	}

}