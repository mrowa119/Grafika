package lab3.Exercise1;

import java.awt.Point;
import java.awt.Polygon;

import lab3.Exercise1.matrix.TransformationMatrix;

public class CartesianPolygon extends Polygon {

	private static final long serialVersionUID = 1276236478032689983L;

	public CartesianPolygon() {
	}

	public CartesianPolygon(CartesianPolygon cartesianPolygon, TransformationMatrix transformationMatrix) {
		for (int i = 0; i < cartesianPolygon.getNumbersOfPoints(); i++) {
			addPoint(transformationMatrix.getTransformedPoint(cartesianPolygon.getPoint(i)));
		}
	}

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

	private void addPoint(Point point) {
		addPoint(point.x, point.y);
	}

	private Point getPoint(int i) {
		return new Point(xpoints[i], ypoints[i]);
	}
	
	private int getNumbersOfPoints() {
		return npoints;
	}

	public int getMaxY() {
		return Tools.getMax(ypoints);
	}

	public int getMinY() {
		return Tools.getMin(ypoints);
	}

	public int getMaxX() {
		return Tools.getMax(xpoints);
	}

	public int getMinX() {
		return Tools.getMin(xpoints);
	}

}
