package problem21thru30;

import utility.Fibonacci;
import utility.Print;

public class Problem25 {

	/*
	 * The 12th term, F12=144, is the first Fibonacci term to contain three digits.
	 * What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
	 */
	public static void main(String[] args) {
//		int n = 3;
		int n = 1000;
		long answer = fibonacciIndex(n);
		Print.answer(answer);
	}

	private static long fibonacciIndex(int n) {
		String fx = "1";//int x = 1;
		String fy = "1";int y = 2;
		while (fy.length() < n) {
			System.out.println(y+": " + fy);
			String next = Fibonacci.nextFibonacci(fx, fy);
			fx = fy;
			fy = next;
			y++;
		}
		System.out.println("FY: " + fy);
		return y;
	}

	

}
