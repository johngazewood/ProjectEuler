package problem11thru20;

import java.math.BigInteger;

import utility.Print;

public class Problem20 {
	
	/*
	 * n! means n × (n − 1) × ... × 3 × 2 × 1
	 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
	 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
	 * Find the sum of the digits in the number 100!
	 */
	
	public static void main(String arar[]) {
		int n = 100;
		long answer = factorialDigitSum(n);
		Print.answer(answer);
	}

	private static long factorialDigitSum(int n) {
		BigInteger factorial = new BigInteger("1");
		
		for (int i = n; i > 0; i--) {
			System.out.println("" + factorial);
			factorial = factorial.multiply(new BigInteger(i+""));
					
		}
		String string = factorial.toString();
		long sum = 0;
		for (String x : string.split("")) {
			sum += Long.parseLong(x);
		}
		return sum;
	}

}
