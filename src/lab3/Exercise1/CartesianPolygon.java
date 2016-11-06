package lab3.Exercise1;

import java.awt.Point;
import java.awt.Polygon;

public class CartesianPolygon extends Polygon {

	private static final long serialVersionUID = 1276236478032689983L;

	// #TODO: UPDATE TO MOVE VECTOR
	public void updatePoints(Point middlePoint) {
		for (int i = 0; i < xpoints.length; i++) {
			xpoints[i] += (int) middlePoint.getX();
			ypoints[i] += (int) middlePoint.getY();
		}

	}

	public void addPoints(String[] coordinates) throws WrongNumberCoordinates {
		if (coordinates.length % 2 == 1) {
			throw new WrongNumberCoordinates();
		}
		for (int i = 0; i < coordinates.length; i += 2) {
			addPoint(coordinates[i], coordinates[i + 1]);
		}
	}

	private void addPoint(String x, String y) {
		addPoint(Integer.parseInt(x), Integer.parseInt(y));
	}

}
