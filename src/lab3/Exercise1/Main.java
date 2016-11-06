package lab3.Exercise1;

public class Main {

	static int TEMP_MIN_X = -50;
	static int TEMP_MAX_X = 100;
	static int TEMP_MIN_Y = -100;
	static int TEMP_MAX_Y = 50;

	static CartesianPolygon[] polygons;

	public static void main(String[] args) {
		int width = Cartesian.getDimmension(TEMP_MIN_X, TEMP_MAX_X);
		int height = Cartesian.getDimmension(TEMP_MIN_Y, TEMP_MAX_Y);

		polygons = new CartesianPolygon[3];

		polygons[0] = new CartesianPolygon();
		polygons[0].addPoint(10, 10);
		polygons[0].addPoint(10, 30);
		polygons[0].addPoint(30, 30);

		polygons[1] = new CartesianPolygon();
		polygons[1].addPoint(40, 50);
		polygons[1].addPoint(40, 60);
		
		polygons[2] = new CartesianPolygon();
		polygons[2].addPoint(-70, -80);
		polygons[2].addPoint(-70, 90);
		polygons[2].addPoint(90, 90);
		polygons[2].addPoint(90, -80);

		Cartesian cartesian = new Cartesian(width, height);
		cartesian.drawPolygons(polygons);
		cartesian.saveToFile();
	}

}
