package lab2.shapes;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;

public class MyShape implements Serializable {

	private static final long serialVersionUID = -9175294510109033402L;

	private int SIZE = 8;

	private int redColour;
	private int greenColour;
	private int blueColour;
	private int shapeType;
	private Shape shape;
	private Rectangle2D[] points;

	public MyShape(int redColour, int greenColour, int blueColour, int shapeType, Shape shape) {
		super();
		this.redColour = redColour;
		this.greenColour = greenColour;
		this.blueColour = blueColour;
		this.shapeType = shapeType;
		setShape(shape);

	}

	public Rectangle2D[] getPoints() {
		return points;
	}

	public int getRedColour() {
		return redColour;
	}

	public void setRedColour(int redColour) {
		this.redColour = redColour;
	}

	public int getGreenColour() {
		return greenColour;
	}

	public void setGreenColour(int greenColour) {
		this.greenColour = greenColour;
	}

	public int getBlueColour() {
		return blueColour;
	}

	public void setBlueColour(int blueColour) {
		this.blueColour = blueColour;
	}

	public int getShapeType() {
		return shapeType;
	}

	public void setShapeType(int shapeType) {
		this.shapeType = shapeType;
	}

	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;

		points = new Rectangle2D[4];

		double minXEditingPointStart = getStartX() - (SIZE / 2);
		double minYEditingPointStart = getStartY() - (SIZE / 2);
		double maxXEditingPointStart = getEndX() - (SIZE / 2);
		double maxYEditingPointStart = getEndY() - (SIZE / 2);

		points[0] = new Rectangle2D.Double(minXEditingPointStart, minYEditingPointStart, SIZE, SIZE);
		points[1] = new Rectangle2D.Double(minXEditingPointStart, maxYEditingPointStart, SIZE, SIZE);
		points[2] = new Rectangle2D.Double(maxXEditingPointStart, minYEditingPointStart, SIZE, SIZE);
		points[3] = new Rectangle2D.Double(maxXEditingPointStart, maxYEditingPointStart, SIZE, SIZE);
	}

	public double getEndY() {
		return shape.getBounds2D().getMaxY();
	}

	public double getEndX() {
		return shape.getBounds2D().getMaxX();
	}

	public double getStartY() {
		return shape.getBounds2D().getMinY();
	}

	public double getStartX() {
		return shape.getBounds2D().getMinX();
	}

	public int getRGB() {
		return (redColour << 16) + (greenColour << 8) + blueColour;
	}

	public Color getPaint() {
		return new Color(getRGB());
	}

}
