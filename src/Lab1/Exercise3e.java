package Lab1;

public class Exercise3e extends MyImage implements Processable {

	// Kolory
	final int figureColor = Tools.int2RGB(0, 0, 0);
	final int backgroundColor = Tools.int2RGB(255, 255, 255);

	final double angle = 11.5 ;

	@Override
	public void processImage(int i, int j) {
		int distanceFromCenterX = xC - i;
		int distanceFromCenterY = yC - j;

		int x =  (int) Math.toDegrees(Math.atan2(distanceFromCenterY,distanceFromCenterX));
		
		int s = (int) (x/angle);
		if (s%2!=0) {
			setColour(i, j, figureColor);
		} else {
			setColour(i, j, backgroundColor);
		}
	}

	public static void main(String[] args) {
		new Exercise3e().renderAndSave();
	}

}