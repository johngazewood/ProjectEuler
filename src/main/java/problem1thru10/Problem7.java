package problem1thru10;

import java.util.Map;

import utility.Prime;
import utility.Print;

public class Problem7 {
	
	/*
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
	 * What is the 10 001st prime number?
	 */
	public static void main(String[] args) {
//		long n = 6;
		long n = 10001;
		long answer = getNthPrimeNumber(n);
		Print.answer(answer);
		// 104743
		// correct!
	}

	public static long getNthPrimeNumber(long n) {
//		long x = 9223372036854775807L;
		long x = Long.MAX_VALUE;
		Map<Long, Integer> bigMap = Prime.getMapOfPrimeDivisorsToPowers(x);
		System.out.println("oh my> " + bigMap);
		
		int position = 1;
		long prime = 2;
		while (position < n+1) {
			System.out.println("prime #" + position + " is " + prime);
			prime = Prime.nextPrime(prime);
			position++;
		}
		
		return prime;
	}

	

}
