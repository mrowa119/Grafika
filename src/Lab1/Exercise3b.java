package Lab1;

public class Exercise3b extends MyImage implements Processable {

	// Kolory
	final int figureColor = Tools.int2RGB(0, 0, 0);
	final int backgroundColor = Tools.int2RGB(255, 255, 255);

	// Rozmial pola
//	final int fieldSize = (int)(500/Math.sqrt(2));
	final int fieldSize = 20;

	// Po³owa przek¹tnej
	final int diagonalOfSquare = (int) (fieldSize * Math.sqrt(2));
	final int halfDiagonalOfSquare = diagonalOfSquare / 2;

	@Override
	public void processImage(int i, int j) {
		int distanceFromSideCenterX = Math.abs(xC - j);
		int distanceFromSideCenterY = Math.abs(yC - i);

		int distanceFromCenterOfVirtualSquareX = Math.abs((distanceFromSideCenterX%diagonalOfSquare)-halfDiagonalOfSquare);
		int distanceFromCenterOfVirtualSquareY = Math.abs((distanceFromSideCenterY%diagonalOfSquare)-halfDiagonalOfSquare);
		

		if ((distanceFromCenterOfVirtualSquareX+distanceFromCenterOfVirtualSquareY)<halfDiagonalOfSquare){
			setColour(i, j, figureColor);
		} else {
			setColour(i, j, backgroundColor);
		}
	}
	
	public static void main(String[] args) {
		new Exercise3b().renderAndSave();
	}

}