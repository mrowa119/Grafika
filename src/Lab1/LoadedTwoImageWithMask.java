package Lab1;

import java.awt.image.BufferedImage;
import java.io.File;

public abstract class LoadedTwoImageWithMask extends LoadedImage {

	BufferedImage image2 = loadSecoundImage();

	BufferedImage mask = new Exercise1a().render();

	// Warotœci pliku wyjœciowego
	final String inputFile2Name = "inputV2";
	final String inputFile2Extension = "jpg";
	final String inputFile2Format = "jpeg";

	private BufferedImage loadSecoundImage() {
		File inputFile = new File(inputFile2Name + "." + inputFile2Extension);
		return super.loadImageFromFile(inputFile);
	}

	protected int getColour2(int i, int j) {
		return image2.getRGB(j, i)  & 0x00FFFFFF;
	}
	
	protected int getMaskColour(int i, int j) {
		return mask.getRGB(j, i)  & 0x00FFFFFF;
	}
}
