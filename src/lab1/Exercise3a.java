package lab1;

public class Exercise3a extends MyImage implements Processable {

	// Kolory
	final int figureColor = Tools.int2RGB(0, 0, 0);
	final int backgroundColor = Tools.int2RGB(211, 211, 211);

	// Srednica kola
	final int radius = 35;
	final int gap = 10;
	final int virtualSquare = 2 * (radius + gap);
	final int halfVirtualSquare = radius + gap;

	@Override
	public void processImage(int i, int j) {
		int distanceFromCenterX = (int) getDistanceToPoint(i, j, xC, i);
		int distanceFromCenterY = (int) getDistanceToPoint(i, j, j, yC);

		int distanceFromCenterOfVirtualSquareX = Math.abs((distanceFromCenterX % virtualSquare) - halfVirtualSquare);
		int distanceFromCenterOfVirtualSquareY = Math.abs((distanceFromCenterY % virtualSquare) - halfVirtualSquare);

		int distanceFromNearestCenter = getDistanceFromNearestCenter(distanceFromCenterOfVirtualSquareX,
				distanceFromCenterOfVirtualSquareY);

		if (distanceFromNearestCenter < radius) {
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
		new Exercise3a().renderAndSave();
	}

}