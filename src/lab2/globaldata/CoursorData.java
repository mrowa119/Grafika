package lab2.globaldata;

import java.awt.Color;

public class CoursorData {
	public static int RED_COURSOR;
	public static int GREEN_COURSOR;
	public static int BLUE_COURSOR;
	
	public static int SHAPE_COURSOR;

	
	
	
	public static int getRGB() {
		RED_COURSOR %= 256;
		GREEN_COURSOR %= 256;
		BLUE_COURSOR %= 256;
		return (RED_COURSOR << 16) + (GREEN_COURSOR << 8) + BLUE_COURSOR;
	}
	
	public static Color getPaint() {
		return new Color(getRGB()); 
	}
}
