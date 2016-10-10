package Lab1;

public class Exercise3c extends MyImage implements Processable {

	// Kolory
	final int figureColor = Tools.int2RGB(0, 0, 0);
	final int backgroundColor = Tools.int2RGB(255, 255, 255);

	// Rozmial pola
	int ringWidth = 1;

	@Override
	public void processImage(int i, int j) {
		int distanceFromCenter = (int) getDistanceToCenter(i, j);
		int numberOfRingsBefor = (int) Math.sqrt(distanceFromCenter*5);
		
		if (numberOfRingsBefor%2==0){
			setColour(i, j, figureColor);
		} else {
			setColour(i, j, backgroundColor);
		}
	}
	
	public static void main(String[] args) {
		new Exercise3c().renderAndSave();
	}

}