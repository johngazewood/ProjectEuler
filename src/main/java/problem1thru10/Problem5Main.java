package problem1thru10;

import java.util.HashMap;
import java.util.Map;

import utility.Prime;
import utility.Print;

public class Problem5Main {

	/*
	 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
	 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
	 */
	
	public static void main(String[] args) {
//		long n = 10;
		long n = 20;
		long answer = smallestMultiple(n);
		Print.answer(answer);
		//232792560
		// correct!!
	}

	private static long smallestMultiple(long n) {
		return primeDivisorPowerMapApproach(n);
	}

	
	public static long primeDivisorPowerMapApproach(long n) {

		Map<Long, Integer> resultantMap = new HashMap<Long, Integer>();
		for (long i = 2; i <= n; i++) {
			Map<Long, Integer> primePowers = Prime.getMapOfPrimeDivisorsToPowers(i);
			System.out.println("for " + i + " the primes are " + primePowers);
			resultantMap = updateResultantMap(resultantMap, primePowers);
		}
		
		Long value = Prime.getValueOfPrimeDivisorPowers(resultantMap);
		return value;
	}

	
	public static Map<Long, Integer> updateResultantMap(Map<Long, Integer> resultantMap, Map<Long, Integer> primePowers) {
		for (Long key : primePowers.keySet()) {
			Integer power = primePowers.get(key);
			if (null == resultantMap.get(key) 
				|| resultantMap.get(key) < power) {
				resultantMap.put(key, power);
			} 
		}
		return resultantMap;
	}


}
