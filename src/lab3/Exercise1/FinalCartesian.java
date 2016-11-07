package lab3.Exercise1;

public class FinalCartesian extends Cartesian {

	public FinalCartesian(Cartesian cartesian) {
		super(cartesian.getWidth(), cartesian.getHeight());
		for(int i=0; i<getHeight();i++){
			for(int j=0; j<getWidth();j++){
				setRGB(j, i, cartesian.getRGB(j, cartesian.getHeight()-i-1));
			}
		}
	}

}
