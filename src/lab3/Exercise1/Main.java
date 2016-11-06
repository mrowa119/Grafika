package lab3.Exercise1;

public class Main {
	
	static int TEMP_MIN_X = -50;
	static int TEMP_MAX_X = 50;
	static int TEMP_MIN_Y = -50;
	static int TEMP_MAX_Y = 50;

	public static void main(String[] args) {
		int width = Cartesian.getDimmension(TEMP_MIN_X, TEMP_MAX_X);
		int height = Cartesian.getDimmension(TEMP_MIN_Y, TEMP_MAX_Y);
		Cartesian cartesian = new Cartesian(width, height);
	}

}
