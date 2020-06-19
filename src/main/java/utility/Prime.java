package utility;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Prime {

	public static boolean isPrime(int p) {
		return isPrime((long) p);
	}

	public static boolean isPrime(long p) {
		if (p <= 0 || p == 2 || p == 1) {
			return false;
		}
		for (int i = 2; i < (p/2+1); i++) {
			if (p % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static List<Long> getListOfPrimeDivisors(long n) {
		return new LinkedList<Long>(getMapOfPrimeDivisorsToPowers(n).keySet());
	}
	
	public static Map<Long, Integer> getMapOfPrimeDivisorsToPowers(long n) {
		Map<Long, Integer> divisorPower = new HashMap<Long, Integer>();
		if (n < 3) {
			if (n == 3) {
				divisorPower.put(3L, 1);
			} else if (n==2) {
				divisorPower.put(2L, 1);
			}
			return divisorPower;
		}
		Long remainder = n;
		Long currentDivisor = 2L;
		
		boolean breakingDown = true;
		while (breakingDown) {
			if (remainder % currentDivisor == 0) {
//				System.out.println("Prime.getMapOfPrimeDivisorsToPowers>> " + currentDivisor + " divides " + remainder);
				if (null == divisorPower.get(currentDivisor)) {
					divisorPower.put(currentDivisor, 1);
				} else {
					divisorPower.put(currentDivisor, 1+divisorPower.get(currentDivisor));
				}
				remainder = remainder / currentDivisor;
//				System.out.println("Prime.getMapOfPrimeDivisorsToPowers>> new remainder: " + remainder);
			} else {
				currentDivisor += 1L;
			}
			breakingDown = Long.compare(remainder, 1L) != 0;
		}
		return divisorPower;
	}
	
	
	public static Long getValueOfPrimeDivisorPowers(Map<Long, Integer> resultantMap) {
		long value = 1;
		for (Long base : resultantMap.keySet()) {
			long power = (long) resultantMap.get(base);
			long m = (long) Math.pow(base, power);
			value *= m;
		}
		return value;
	}
	
	public static List<Long> getListOfPrimesLessThan(long n) {
		List<Long> primes = new LinkedList<Long>();
		return primes;
	}
	
	public static List<Long> primes = new LinkedList<Long>();
	public static long nextPrime(long i) {
		
		if (i < 2) {
			primes.add(2L);
			return 2;
		}
		
		boolean found = false;
		long p = i;
		while (!found) {
			p++;
			found = isNextPrime(p);
		}
		primes.add(p);
		return p;
	}

	private static boolean isNextPrime(long p) {
		if (primes.isEmpty() && isPrime(p)) {
			primes.add(p);
			return true;
		}
		
		for (long prime : primes) {
			if (p % prime == 0) {
				return false;
			}
		}
		primes.add(p);
		return true;
	}
	
}
