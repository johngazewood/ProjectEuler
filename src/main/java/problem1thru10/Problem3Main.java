package problem1thru10;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utility.Prime;
import utility.Print;

public class Problem3Main {
/*
	The prime factors of 13195 are 5, 7, 13 and 29.

	What is the largest prime factor of the number 600851475143 ?
	*/
	public static void main(String[] args) {
		long target = 600851475143L;
//		long n = 10;
		long n = 13195;
//		n = 7919 * 3 * 3 * 1223;
		n = target;
		
		
		System.out.println("n = " + n);
		System.out.println("n < ? " + (n < target));
		long largestPrime = findLargestPrime(n);
		Print.answer(largestPrime);
		//6857
	}

	private static long findLargestPrime(long n) {
//		return breakDown(n);
		return breakDownWithLibrary(n);
	}
	
	private static long breakDownWithLibrary(long n) {
		List<Long> primeDivisors = Prime.getListOfPrimeDivisors(n);
		Long largest = Collections.max(primeDivisors);
		return largest;
	}

	public static long breakDown(long n) {
		Map<Long, Integer> divisorPower = new HashMap<Long, Integer>();
		Long remainder = n;
		Long currentDivisor = 2L;
		
		boolean breakingDown = true;
		while (breakingDown) {
			if (remainder % currentDivisor == 0) {
				System.out.println(currentDivisor + " divides " + remainder);
				if (null == divisorPower.get(currentDivisor)) {
					divisorPower.put(currentDivisor, 1);
				} else {
					divisorPower.put(currentDivisor, 1+divisorPower.get(currentDivisor));
				}
				remainder = remainder / currentDivisor;
				System.out.println("new remainder: " + remainder);
			} else {
				currentDivisor += 1L;
			}
			breakingDown = Long.compare(remainder, 1L) != 0;
		}
		System.out.println("divisorPower = " + divisorPower);
		
		Long largest = Collections.max(divisorPower.keySet());
		return largest;
	}

	/*
	public static long findDivisorsThenFindPrimes(long n) {
		long largestPrime = -1;
		List<Long> divisors = new LinkedList<Long>();
		for (long i = n / 2; i > 1; i--) {
			System.out.println(""+i);
			if (n % i == 0) {
				System.out.println( i + " is a divisor");
				divisors.add(i);
			}
		}
		System.out.println("The number of divisors is " + divisors.size());
		return largestPrime;
	}

	public static long findLargestPrime_topDown(long n) {
		long largestPrime = -1;
		System.out.println("starting i at " + n/2);
		for (long i = n / 2; i > 1; i--) {
			if (n % i == 0) {
				System.out.println( i + " is a divisor");
				if(Prime.isPrime(i)) {
					System.out.println("Largest prime updating to " + i);
					largestPrime = i;
					break;
				}
			}
				
			
		}
		return largestPrime;
	}

	public static long findLargestPrime_bottomUp(long n) {
		long largestPrime = -1;
		
		for (long i = 2; i < n / 2; i++) {
			if (n % i == 0 && Prime.isPrime(i)) {
				System.out.println("Largest prime updating to " + i);
				largestPrime = i;
			}
		}
		return largestPrime;
	}
*/
	
}
