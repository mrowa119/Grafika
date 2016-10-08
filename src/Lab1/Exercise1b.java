package Lab1;

public class Exercise1b extends MyImage {

	// Szerokoœæ lini kratki
	final int lineWidth = 50;

	// Odleg³oœæ pomiêdzy œrodkami lini
	final int distanceBetweenMiddleOfLinesX = 3 * lineWidth;
	final int distanceBetweenMiddleOfLinesY = 2 * lineWidth;

	// Kolory
	int figureColor = Tools.int2RGB(0, 0, 0);
	int backgroundColor = Tools.int2RGB(255, 255, 255);

	@Override
	public void processImage() {
		for (int i = 0; i < yRes; i++) {
			for (int j = 0; j < xRes; j++) {
				int distanceFromCenterX = Math.abs(xC - j);
				int distanceFromCenterY = Math.abs(yC - i);
				
				if(distanceFromApsoluteCenterX(distanceFromCenterX)>distanceFromMiddleLine() && distanceFromApsoluteCenterY(distanceFromCenterY)>distanceFromMiddleLine()){
					setColour(i, j, backgroundColor);
				} else{
					setColour(i, j, figureColor);
				}
			}
		}
		saveImage();
	}

	private int distanceFromMiddleLine() {
		return lineWidth/2;
	}

	private int distanceFromApsoluteCenterY(int distanceFromCenterY) {
		return Math.abs(distanceFromCenterY%distanceBetweenMiddleOfLinesY-(distanceBetweenMiddleOfLinesY/2));
	}

	private int distanceFromApsoluteCenterX(int distanceFromCenterX) {
		return Math.abs(distanceFromCenterX%distanceBetweenMiddleOfLinesX-(distanceBetweenMiddleOfLinesX/2));
	}
	
	private void setColour(int i, int j, int color) {
		image.setRGB(j, i, color);
	}

	public static void main(String[] args) {
		new Exercise1b().processImage();
	}

}
