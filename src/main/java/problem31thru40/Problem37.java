package problem31thru40;

import utility.Prime;
import utility.Print;

public class Problem37 {

	/*
	 * The number 3797 has an interesting property. Being prime itself, it is possible to continuously remove digits from left to right, 
	 * and remain prime at each stage: 3797, 797, 97, and 7. Similarly we can work from right to left: 3797, 379, 37, and 3.
	 * 
	 * Find the sum of the only eleven primes that are both truncatable from left to right and right to left.
	 * 
	 * NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
	 */
	
	public static void main(String[] args) {
//		int upperbound = 1000;
		//don't need an upperbound because we know there's only 11.
		long answer = truncatablePrimes();
		//took about 2 minutes to run.x
		Print.answer(answer);
	}

	static long truncatablePrimes() {
		int numOfTruncatables = 11;//10 is easy to find
		int count = 0;
		long sum = 0;
		long prime = 1;
		while (count < numOfTruncatables) {
			prime = Prime.nextPrime(prime);
			System.out.print("prime: " + prime);
			if (prime > 7 && primeIsTruncatable(prime)) {
				System.out.print(" is truncatable\n");
				count++;
				sum += prime;
			} else {
				System.out.print("\n");
			}
		}
		return sum;
	}

	static boolean primeIsTruncatable(long prime) {
		if (prime < 10) {
			return true;
		}
		boolean leftTruncatable = isLeftTruncatable(prime);
		boolean rightTruncatable = isRightTruncatable(prime);
		
		return leftTruncatable && rightTruncatable;
	}

	public static boolean isRightTruncatable(long prime) {
		long rightTruncated = getRightTruncated(prime);
		if (rightTruncated < 10) {
			//could be that rightTruncated  == 4
			return Prime.primesNext.contains(rightTruncated);
		}
		if (Prime.primesNext.contains(rightTruncated)) {
			return isRightTruncatable(rightTruncated);
		}
		return false;
	}

	public static boolean isLeftTruncatable(long prime) {
		long leftTruncated = getLeftTruncated(prime);
		if (leftTruncated < 10) {
			//could be that rightTruncated  == 4
			return Prime.primesNext.contains(leftTruncated);
		}
		if (Prime.primesNext.contains(leftTruncated)) {
			return isLeftTruncatable(leftTruncated);
		}
		return false;
	}

	public static long getRightTruncated(long prime) {
		String string = prime+"";
		String substring = string.substring(0, string.length()-1);
		long truncatedLong = Long.parseLong(substring);
		return truncatedLong;
	}

	public static long getLeftTruncated(long prime) {
		String string = prime+"";
		String substring = string.substring(1, string.length());
		long truncatedLong = Long.parseLong(substring);
		return truncatedLong;
	}

}
