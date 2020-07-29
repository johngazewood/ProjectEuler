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
//		long answer = approach1();
		long answer = approach2();
		return answer;
	}

	/*
	 * Generate pandigitals, keep track of the largest prime.
	 * 
	 * Took about 2 minutes to print all the pandigitals (i.e. less than or equal to 987654321)
	 */
	static long approach2() {
		long largest = -1;
		List<Long> pandigitals = new LinkedList<Long>();
		for (long i = 1; i <= 987654321; i++) {
			if (Pandigital.isPandigital(i)) {
				pandigitals.add(i);
			}
		}
		System.out.println("Problem41>> sorting... ");
		Collections.sort(pandigitals, Collections.reverseOrder());
		System.out.println("Problem41>> sorted. ");
		for (Long l : pandigitals) {
			if (Prime.isPrime(l)) {
				System.out.println("Problem41>> found " + l);
				largest = l;
				break;
			} else {
				System.out.println(String.format("Problem41>> %s is not prime.", l));
			}
		}
		
		return largest;
	}

	/*
	 * While generating all primes <= 987654321,
	 * collect those which are pandigital.
	 * Find the largest panditigal in that list.
	 * 
	 * This ran for more than 24 hours.
	 */
	public static long approach1() {
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
