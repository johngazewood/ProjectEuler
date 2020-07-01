package problem21thru30;

import java.util.HashSet;
import java.util.Set;

import utility.Prime;
import utility.Print;

public class Problem21 {

	/*
	 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
	 * If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.
	 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. 
	 * The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
	 * Evaluate the sum of all the amicable numbers under 10000.
	 */
	
	public static void main(String[] args) {
		int n = 10000;
		long answer = amicableNumberSolution(n);
		Print.answer(answer);
	}

	static Set<Long> amicableNumbers;
	
	private static long amicableNumberSolution(int n) {
		amicableNumbers = new HashSet<Long>();
		
		for (long i = 1; i < n; i++) {
			if (! amicableNumbers.contains(i)) {
				long a = calculateAmicableNumber(i);
				if (a > 0) {
					amicableNumbers.add(a);
					amicableNumbers.add(i);
				}
			}
		}
		
		int sum = 0;
		for (Long i : amicableNumbers) {
			sum += i;
		}
		return sum;
	}

	public static long calculateAmicableNumber(long i) {
		long v1 = amicableValue(i);
		long v2 = amicableValue(v1);
		if (i == v2 && v1 != v2) {
			System.out.println(String.format("Problem21>> amicable pair!! %s and %s", i, v1));
			return v1;
		} else {
			return -1;
		}
	}

	public static long amicableValue(long i) {
		if (i < 2) {
			return -1;
		}
		Set<Long> properDivisors = Prime.calculateDivisors(i);
		//we want proper divisors.
		properDivisors.remove(i);
		long sum = 0;
		for (Long d : properDivisors) {
			sum += d;
		}
		return sum;
	}

}
