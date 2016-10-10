package Lab1;

public class Exercise4 extends LoadedTwoImageWithMask {

	@Override
	public void processImage(int i, int j) {

		double factorRed = Tools.RGB2red(getMaskColour(i, j)) / 255.0;
		int imageRed = Tools.RGB2red(getColour(i, j));
		int image2Red = Tools.RGB2red(getColour2(i, j));
		int outputRed = (int) (imageRed * factorRed + (1 - factorRed) * image2Red);

		double factorGreen = Tools.RGB2green(getMaskColour(i, j)) / 255.0;
		int imageGreen = Tools.RGB2green(getColour(i, j));
		int image2Green = Tools.RGB2green(getColour2(i, j));
		int outputGreen = (int) (imageGreen * factorGreen + ((1 - factorGreen) * image2Green));

		double factorBlue = Tools.RGB2blue(getMaskColour(i, j)) / 255.0;
		int imageBlue = Tools.RGB2blue(getColour(i, j));
		int image2Blue = Tools.RGB2blue(getColour2(i, j));
		int outputBlue = (int) (imageBlue * factorBlue + ((1 - factorBlue) * image2Blue));

		setColour(i, j, Tools.int2RGB(outputRed, outputGreen, outputBlue));
	}

	public static void main(String[] args) {
		new Exercise4().renderAndSave();
	}

}
