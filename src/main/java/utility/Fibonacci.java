package utility;

import java.math.BigInteger;

public class Fibonacci {

	public static String nextFibonacci(String fx, String fy) {
		BigInteger FX = new BigInteger(fx);
		BigInteger FY = new BigInteger(fy);
		BigInteger next = FX.add(FY);
		return next.toString();
	}
	
}
