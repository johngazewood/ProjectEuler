package problem41thru50;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import utility.Pandigital;
import utility.Prime;
import utility.Print;

public class Problem41 {

	/*
	 * We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once. 
	 * For example, 2143 is a 4-digit pandigital and is also prime.
	 * What is the largest n-digit pandigital prime that exists?
	 */
	
	public static void main(String[] args) {
		long answer = pandigitalPrime();
		Print.answer(answer);
	}

	private static long pandigitalPrime() {
		long answer = approach1();
		return answer;
	}

	/*
	 * While generating all primes <= 987654321,
	 * collect those which are pandigital.
	 * Find the largest panditigal in that list.
	 */
	public static long approach1() {
		/*
		 * List pandigitalPrimes = new List();
		 * int prime = 1;
		 * while (prime < 987654321) {
		 *   prime = Prime.nextPrime(prime);
		 *   if (Pandigital.isPandigital(prime)) {
		 *     pandigitalPrimes.add(prime);
		 *   }
		 * }
		 * 
		 * return Collections.max(pandigitalPrimes);
		 */
		List<Long> pandigitalPrimes = new LinkedList<Long>();
		long prime = 1;
		while (prime < 987654321) {
			prime = Prime.nextPrime(prime);
			if (Pandigital.isPandigital(prime)) {
				System.out.println(String.format("Problem41>> %s is pandigital", prime));
				pandigitalPrimes.add(prime);
			}
		}
		long big = Collections.max(pandigitalPrimes);
		return big;
	}

}
