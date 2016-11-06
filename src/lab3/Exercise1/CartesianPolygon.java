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

}
