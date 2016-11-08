package lab3.Exercise6.Interpolations;

import static org.junit.Assert.assertEquals;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

public class BipolarInterpolationTest {
	
	private static BipolarInterpolation interpolation;

	@Before
	public void executedBeforeEach() {
		interpolation = new BipolarInterpolation();
	}

	@Test
	public void bipolarRedInterpolationTest() {
		int expected = 4;
		//Given
		double[] sourcePoint = new double[] {
				3.3,
				4.8
		};
		
		int[] sourceColours = new int[]{
				new Color(5,0,0).getRGB(),
				new Color(8,0,0).getRGB(),
				new Color(4,0,0).getRGB(),
				new Color(1,0,0).getRGB()
		};
		
		//Then
		int result = interpolation.getRedColour(sourcePoint, sourceColours);

		//When
		assertEquals(expected, result);
	}
	
	@Test 
	public void interpolationFactorTest(){
		double expected = 0.5;
		//Given
		double point = 2.5;
		//Then
		double result = interpolation.interpolationFactor(point);
		//Whem
		assertEquals(expected, result, 0);
	}
	
	@Test 
	public void interpolationBoundsFactorTest(){
		double expected = 0;
		//Given
		double point = 2;
		//Then
		double result = interpolation.interpolationFactor(point);
		//Whem
		assertEquals(expected, result, 0);
	}
	
}
