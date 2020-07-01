package problem11thru20;

import java.math.BigInteger;

public class Problem15_RETURN {

	/*
	 * Starting in the top left corner of a 2×2 grid, 
	 * and only being able to move to the right and down, 
	 * there are exactly 6 routes to the bottom right corner.
	 * 
	 * How many such routes are there through a 20×20 grid?
	 */
	
	public static void main(String[] args) {
		System.out.println(factorial(21));
	}

	public static BigInteger factorial(long number) {
        BigInteger result = BigInteger.valueOf(1);

        for (long factor = 2; factor <= number; factor++) {
            result = result.multiply(BigInteger.valueOf(factor));
        }

        return result;
    }
	
}
