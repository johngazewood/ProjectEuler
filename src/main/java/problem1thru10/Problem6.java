package problem1thru10;

import utility.Print;

public class Problem6 {

	/*
	 * when n = 10...
	 * 1^2 + 2^2 + ... + 10^2 = 385
	 * (1+2+...10)^2 = 3025
	 * 3025 - 385 = 2640
	 * f(n) = 2640
	 * 
	 * f(100)?
	 */
	public static void main(String[] args) {
		long n = 100;
		
		long answer = sumSquareDifference(n);
		Print.answer(answer);
		//25164150
	}

	private static long sumSquareDifference(long n) {
		long sumOfSquares = 0; //1^2 + 2^2 ...
		long squareOfSum = 0; //(1+2+...)^2
		
		for (int i = 1; i <= n; i++) {
			sumOfSquares += (long) Math.pow(i, 2);
			squareOfSum += i;
		}
		squareOfSum = (long) Math.pow(squareOfSum, 2);
		
		
		return squareOfSum - sumOfSquares;
	}

}
