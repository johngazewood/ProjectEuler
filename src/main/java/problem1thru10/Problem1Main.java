package problem1thru10;

import utility.Print;

public class Problem1Main {

	/**
	 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. 
	 * The sum of these multiples is 23.
	 * Find the sum of all the multiples of 3 or 5 below 1000.
   	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 1000;
		int sum = findSum(n);
		Print.answer(sum);
		//233168
		//correct!!
	}

	private static int findSum(int n) {
		int sum = 0;
		for (int i = 1; i < n; i++) {
			if (i % 3 == 0 || i % 5 == 0) {
				System.out.println(i + " --- is a multiple of 3 or 5");
				sum += i;
			}
		}
		return sum;
	}

}
