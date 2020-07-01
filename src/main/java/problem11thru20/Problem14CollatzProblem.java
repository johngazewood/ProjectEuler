package problem11thru20;

import utility.Print;

public class Problem14CollatzProblem {

	/*
	 * The following iterative sequence is defined for the set of positive integers:
	 * n → n/2 (n is even)
	 * n → 3n + 1 (n is odd)
	 * 
	 * Using the rule above and starting with 13, we generate the following sequence:
	 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
	 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. 
	 * Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
	 * Which starting number, under one million, produces the longest chain?
	 * NOTE: Once the chain starts the terms are allowed to go above one million.
	 */
	
	public static void main(String[] args) {
//		long n = 13;
		long n = 1000000;
		long answer = longestChainWithStartingElementN(n); 
		Print.answer(answer);
		//837799
	}

	private static long longestChainWithStartingElementN(long n) {
		long startingNumberWithLongestLength = 0;
		long longestLength = 0;
		while (n > 1) {
			long length = lengthOfChain(n);
//			System.out.println(String.format("Length of chain starting with %s is %s", n, length));
			if (length > longestLength) {
				longestLength = length;
				startingNumberWithLongestLength = n;
			}
			n--;
		}
		return startingNumberWithLongestLength;
	}

	public static long lengthOfChain(long n) {
		long length = 1;
		while (n > 1) {
			n = nextElement(n);
			length++;
		}
		return length;
	}

	public static long nextElement(long n) {
		long next = 0;
		if (n % 2 == 0) {//even
			next = n / 2;
		} else {
			next = (3*n)+1;
		}
		return next;
	}

}
