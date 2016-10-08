package Lab1;

public class Example extends MyImage{

	// Kolory
	int figureColor = Tools.int2RGB(0, 0, 0);
	int backgroundColor = Tools.int2RGB(255, 255, 255);

	// Szerokosc pierscienia
	final int w = 10;
	
	String outputFileName = "example";

	public void processImage() {
		for (int i = 0; i < yRes; i++) {
			for (int j = 0; j < xRes; j++) {
				double d;
				int r;

				d = getDistanceToCenter(i, j);
				r = getRingIndex(d);

				if (isFigure(r)) {
					setFigureColour(i, j);
				} else {
					setBackgroudnColor(i, j);
				}
			}
		}		
		saveImage();
	}

	private void setBackgroudnColor(int i, int j) {
		setColour(i, j, backgroundColor);
	}

	private void setColour(int i, int j, int color) {
		image.setRGB(j, i, color);
	}

	private void setFigureColour(int i, int j) {
		setColour(i, j, figureColor);
	}

	private boolean isFigure(int r) {
		return r % 2 == 0;
	}

	private int getRingIndex(double d) {
		return (int) d / w;
	}

	public static void main(String[] args) {
		new Example().processImage();
	}
}
