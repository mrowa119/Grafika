package lab3.Exercise1;

import java.awt.image.BufferedImage;

public class Cartesian extends BufferedImage {
	
	public Cartesian(int width, int height) {
		super(width, height, BufferedImage.TYPE_INT_RGB);
	}

	
	public static int getDimmension(int min, int max){
		return Math.abs(min)+Math.abs(max)+1;
	}
}
