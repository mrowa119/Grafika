package Lab1;

public class Exercise4 extends LoadedTwoImageWithMask {


	@Override
	public void processImage(int i, int j) {
System.out.println(getMaskColour(i, j));
		if (getMaskColour(i, j)==Tools.int2RGB(0, 0, 0)) {
			setColour(i, j, getColour(i, j));
		} else {
			setColour(i, j, getColour2(i, j));
		}

	}

	public static void main(String[] args) {
		new Exercise4().renderAndSave();
	}

}
