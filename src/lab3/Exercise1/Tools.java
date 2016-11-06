package lab3.Exercise1;

public class Tools {

	public static int getMin(int[] arr){
		int min = Integer.MAX_VALUE;
	    for(int cur: arr)
	    	min = Math.min(min, cur);
	    return min;
	}
	
	public static int getMax(int[] arr){
		int max = Integer.MIN_VALUE;
	    for(int cur: arr)
	    	max = Math.max(max, cur);
	    return max;
	}
}
