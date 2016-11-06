package lab3.Exercise1;

import java.awt.Polygon;

public class Main {
	
	static int TEMP_MIN_X = -50;
	static int TEMP_MAX_X = 75;
	static int TEMP_MIN_Y = -100;
	static int TEMP_MAX_Y = 50;
	
	static Polygon[] polygons; 


	public static void main(String[] args) {
		int width = Cartesian.getDimmension(TEMP_MIN_X, TEMP_MAX_X);
		int height = Cartesian.getDimmension(TEMP_MIN_Y, TEMP_MAX_Y);
		
		polygons = new Polygon[2];
		
		polygons[0] = new Polygon();
		polygons[0].addPoint(10, 10);
		polygons[0].addPoint(20, 20);
		polygons[0].addPoint(-30, -30);
		
		polygons[1] = new Polygon();
		polygons[1].addPoint(10, 10);
		polygons[1].addPoint(20, 10);
		
		
		Cartesian cartesian = new Cartesian(width, height);
		cartesian.drawPolygosn(polygons);
		cartesian.saveToFile();
	}


}
