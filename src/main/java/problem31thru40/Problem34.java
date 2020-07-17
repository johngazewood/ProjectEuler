package problem31thru40;

import utility.Print;

public class Problem34 {

	/*
	 * 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
	 * Find the sum of all numbers which are equal to the sum of the factorial of their digits.
	 * Note: as 1! = 1 and 2! = 2 are not sums they are not included.
	 */
	
	public static void main(String[] args) {
		long answer = digitalFactors();
		Print.answer(answer);
		//40730
	}

	static long digitalFactors() {
		long sum = 0;
//		for (int x = 3; x < Integer.MAX_VALUE; x++) {
		for (int x = 3; x < 41000; x++) {
			if (isDigitalFactor(x)) {
				System.out.println("digital factor: " + x);
				sum += x;
			}
		}
		
		return sum;
	}

	static boolean isDigitalFactor(int x) {
		int y = 0;
		String string = x + "";
		for (int index = 0; index < string.length(); index++) {
			int digit = Integer.parseInt(string.charAt(index)+"");
			int f = factorial(digit);
			y += f;
		}
		
		return x == y;
	}

	static int factorial(int d) {
		int factorial = 1;
		for (int m = d; m > 1; m--) {
			factorial *= m;
		}
		return factorial;
	}
	
	
	

}
