package lab2.shapes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.Serializable;

public class MyShape implements Serializable {

	private static final long serialVersionUID = -9175294510109033402L;

	private final static int APEX_SIZE = 8;
	private final static int ICON_SIZE = 20;

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

		double minXEditingPointStart = getStartX() - (APEX_SIZE / 2);
		double minYEditingPointStart = getStartY() - (APEX_SIZE / 2);
		double maxXEditingPointStart = getEndX() - (APEX_SIZE / 2);
		double maxYEditingPointStart = getEndY() - (APEX_SIZE / 2);

		points[0] = new Rectangle2D.Double(minXEditingPointStart, minYEditingPointStart, APEX_SIZE, APEX_SIZE);
		points[1] = new Rectangle2D.Double(minXEditingPointStart, maxYEditingPointStart, APEX_SIZE, APEX_SIZE);
		points[2] = new Rectangle2D.Double(maxXEditingPointStart, minYEditingPointStart, APEX_SIZE, APEX_SIZE);
		points[3] = new Rectangle2D.Double(maxXEditingPointStart, maxYEditingPointStart, APEX_SIZE, APEX_SIZE);
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

	@Override
	public String toString() {
		if (shapeType == 0) {
			return "Prostok¹t";
		} else if (shapeType == 1) {
			return "Elipsa";
		}
		return "BrakNazwy";
	}

	public BufferedImage getIcon() {
		BufferedImage image = new BufferedImage(ICON_SIZE, ICON_SIZE, BufferedImage.TYPE_INT_RGB);
		Graphics2D graph = image.createGraphics();
		graph.setColor(Color.WHITE);
		graph.fill(new Rectangle(0, 0, ICON_SIZE, ICON_SIZE));
		graph.setColor(new Color(redColour, greenColour, blueColour));
		if (shapeType == 0) {
			graph.fill(new Rectangle(0, 0, ICON_SIZE, ICON_SIZE));
		} else if (shapeType == 1) {
			graph.fillOval(0, 0, ICON_SIZE, ICON_SIZE);
		}
		graph.dispose();
		return image;
	}
}
