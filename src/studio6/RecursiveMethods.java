package studio6;

import edu.princeton.cs.introcs.StdDraw;

public class RecursiveMethods {

	/**
	 * Computes the geometric sum for the first n terms in the series
	 * 
	 * @param n the number of terms to include in the sum
	 * @return the sum of the first n terms of the geometric series (1/2 + 1/4 + 1/8
	 *         ...)
	 */
	public static double geometricSum(int n) {
		
		//base case
		if (n == 0) {
			return 0;
		}
			
        // calculate the sum each time
        double ans = 1 / (double)Math.pow(2, n) + geometricSum(n - 1);
 
        // return final answer
        return ans;
		
	}

	/**
	 * This method uses recursion to compute the greatest common divisor
	 * for the two input values
	 * 
	 * @param p first operand
	 * @param q second operand
	 * @return greatest common divisor of p and q
	 */
	public static int gcd(int p, int q) {
		// inverted base case. equivalent to 'while q != 0'
		 if (q != 0) {
			 return gcd(q, p % q);
		 }
		 
	     return p;
		
	}

	

	/**
	 * This method uses recursion to create a reverse of the given array
	 * 
	 * @param array the array to create a reverse of, not to be mutated
	 * @return an array with the same data as the input but it reverse order
	 */
	public static int[] toReversed(int[] array) {
		
			int[] arrayFlippedCopy = new int[array.length]; // create a new array to be mutated by the helper method
			return toReversedHelper(arrayFlippedCopy, array, 0); // return a call to only the helper method with the array to be mutated
		
	}
	
	public static int[] toReversedHelper(int[] arrayFlippedCopy, int[] array,  int index) {
		// base case final index:
		if (index >= array.length) {
			return arrayFlippedCopy;
		}
		
		//fill the reflected index of the copied array with the current index of the original array:
		arrayFlippedCopy[arrayFlippedCopy.length-index-1] = array[index];
		// Return with the next index:
		return toReversedHelper(arrayFlippedCopy, array, index + 1);
		
		
		
		
		
		
	
	}

	/**
	 * @param xCenter                       x-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param yCenter                       y-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param radius                        radius of the circle at the current
	 *                                      depth
	 * @param radiusMinimumDrawingThreshold radius above which drawing should occur
	 */
	public static void circlesUponCircles(double xCenter, double yCenter, double radius,
			double radiusMinimumDrawingThreshold) {
		//base case
		if (radius <= radiusMinimumDrawingThreshold) {
			return;
		}
		//draw!!
		StdDraw.circle(xCenter, yCenter, radius);
		//above
		circlesUponCircles(xCenter, yCenter-radius, radius/3.0, radiusMinimumDrawingThreshold);
		//right
		circlesUponCircles(xCenter+radius, yCenter, radius/3.0, radiusMinimumDrawingThreshold);
		//left
		circlesUponCircles(xCenter-radius, yCenter, radius/3.0, radiusMinimumDrawingThreshold);
		//below
		circlesUponCircles(xCenter, yCenter+radius, radius/3.0, radiusMinimumDrawingThreshold);
	}

}
