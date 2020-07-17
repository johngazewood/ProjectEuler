package problem1thru10;

import java.util.LinkedList;

import utility.Prime;
import utility.Print;

public class Problem10 {

	/*
	 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
	 * Find the sum of all the primes below two million.
	 */
	
	public static void main(String[] args) {
//		long n = 10;
		long n = 2000000;
		long answer = summationOfPrimesBelow(n);
		Print.answer(answer);
		//142913828922
	}

	private static long summationOfPrimesBelow(long n) {
		//make sure this is empty;
		Prime.primesNext = new LinkedList<Long>();
		long currentPrime = 0;
		long sum = 0;
		System.out.println("running...");
		currentPrime = Prime.nextPrime(currentPrime);
		while (currentPrime < n){
			sum += currentPrime;
			System.out.println("currentPrime: " + currentPrime);
			currentPrime = Prime.nextPrime(currentPrime);
//			if (currentPrime < n) {
//				System.out.println("adding prime: " + currentPrime + " to sum " + sum);
				
//				System.out.println("sum is now:   "+sum);
				
//			}
		}
		return sum;
	}

}
