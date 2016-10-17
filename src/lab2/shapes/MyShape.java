package lab2.shapes;

import java.awt.Color;
import java.awt.Shape;
import java.io.Serializable;

public class MyShape implements Serializable{

	private static final long serialVersionUID = -9175294510109033402L;
	
	private int redColour;
	private int greenColour;
	private int blueColour;
	private int shapeType;
	private Shape shape;

	
	public MyShape(int redColour, int greenColour, int blueColour, int shapeType, Shape shape) {
		super();
		this.redColour = redColour;
		this.greenColour = greenColour;
		this.blueColour = blueColour;
		this.shapeType = shapeType;
		this.shape = shape;
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
	}
	
	public int getRGB() {
		return (redColour << 16) + (greenColour << 8) + blueColour;
	}
	
	public Color getPaint() {
		return new Color(getRGB()); 
	}
}
