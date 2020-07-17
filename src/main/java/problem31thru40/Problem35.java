package problem31thru40;

import java.util.LinkedList;
import java.util.List;

import utility.Prime;
import utility.Print;

public class Problem35 {

	/*
	 * The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.
	 * There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
	 * How many circular primes are there below one million?
	 */
	public static void main(String[] args) {
		int n = 1000000;
		//takes about 3 minutes to calculate.
		int answer = circularPrimes(n);
		Print.answer(answer);
		//55
	}

	static int circularPrimes(int n) {
		//return approach_incrementAllNumbers(n);
		return approach_findPrimesFirst(n);
	}

	
	private static int approach_findPrimesFirst(int n) {
		long prime = 1;
		while (prime < n) {
			prime = Prime.nextPrime(prime);
		}
		List<Long> knownPrimes = Prime.primesNext;//makes debugging easier..
		int count = 0;
		for (long p : knownPrimes) {
			String string = p+"";
			long value = p;
			boolean allRotationsArePrime = true;
			for (int r = 0; r < string.length(); r++) {
				if (!Prime.primesNext.contains(value)) {
					allRotationsArePrime = false;
					break;
				}
				string = rotateDigits(string);
				value = Integer.parseInt(string);
			}
			if (allRotationsArePrime) {
				System.out.println("all rotations are prime: " + value);
				count++;
			}
					
		}
		
		return count;
	}
	
	
//----------------------------------------------------------------------------------------
	static int approach_incrementAllNumbers(int n) {
		int count = 0;
		for (int x = 2; x < n; x++) {
			System.out.println(""+x);
			if (isACircularPrime(x)) {
				System.out.println("-------------------circular prime: " + x);
				count++;
			}
		}
		return count;
	}


	static List<Integer> knownCircularPrimes = new LinkedList<Integer>();
	
	static boolean isACircularPrime(int x) {
		if (knownCircularPrimes.contains(x)) {
			return true;
		}
		String string = x+"";
		int value = x;
		List<Integer> localNumbers = new LinkedList<Integer>();
		for (int r = 1; r <= string.length(); r++) {
			localNumbers.add(value);
			if (!Prime.isPrime(value)) {
				return false;
			}
			string = rotateDigits(string);
			value = Integer.parseInt(string);
		}
		knownCircularPrimes.addAll(localNumbers);
		return true;
	}


	static String rotateDigits(String string) {
		String front = string.charAt(0)+"";
		String rotated = string.substring(1,string.length()) + front;
		return rotated;
	}

}
