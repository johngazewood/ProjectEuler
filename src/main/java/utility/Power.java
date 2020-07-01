package utility;

import java.math.BigInteger;

public class Power {

	
	public static BigInteger power(int a, int b) {
		BigInteger A = new BigInteger(a+"");
		BigInteger power = A.pow(b);
		return power;
	}

	public static long power(long a, int b) {
		BigInteger A = new BigInteger(a+"");
		BigInteger bi = A.pow(b);
		Long l = Long.parseLong(bi.toString());
		return l;
	}
	
}
