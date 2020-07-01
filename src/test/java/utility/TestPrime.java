package utility;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class TestPrime {

	
	@Test
	public void test_calculateDivisorsRecur_lastStep() {
		Set<Long> divisors = new HashSet<Long>();
		Long l = 2L;
		Map<Long, Integer> primeDivisors = new HashMap<Long, Integer>();
		primeDivisors.put(3L, 1);
		Set<Long> actual = Prime.calculateDivisorsRecur(divisors, l, primeDivisors);
		Set<Long> expected = new HashSet<Long>();
		expected.add(2L);
		expected.add(6L);
		assertEquals(expected, actual);
		
		divisors = new HashSet<Long>();
		l = 2L;
		primeDivisors = new HashMap<Long, Integer>();
		primeDivisors.put(3L, 2);
		actual = Prime.calculateDivisorsRecur(divisors, l, primeDivisors);
		expected = new HashSet<Long>();
		expected.add(2L);
		expected.add(6L);
		expected.add(18L);
		assertEquals(expected, actual);
	}
	
	@Test
	public void test_calculateDivisorsRecur_secondToLastStep() {
		Set<Long> divisors = new HashSet<Long>();
		Long l = 2L;
		Map<Long, Integer> primeDivisors = new HashMap<Long, Integer>();
		primeDivisors.put(3L, 1);
		primeDivisors.put(5L, 1);
		Set<Long> actual = Prime.calculateDivisorsRecur(divisors, l, primeDivisors);
		Set<Long> expected = new HashSet<Long>();
		expected.add(2L);
		expected.add(6L);
		expected.add(10L);
		expected.add(30L);
//		expected.add(15L);//this won't happen, because we're overlooking the loop for 2^0, 2^1. We're just sending in 2^1.
		assertEquals(expected, actual);
	}
	
	@Test
	public void test_calculateDivisors_30() {
		Set<Long> divisors = Prime.calculateDivisors(30);
		Set<Long> expected = new HashSet<Long>();
		expected.add(1L);
		expected.add(2L);
		expected.add(3L);
		expected.add(5L);
		expected.add(6L);
		expected.add(10L);
		expected.add(15L);
		expected.add(30L);
		assertEquals(expected, divisors);
	}
	
	
//	@Test
	public void testIsPrime() {
		Assert.assertEquals(false, Prime.isPrime(0));
		Assert.assertEquals(false, Prime.isPrime(1));
		Assert.assertEquals(false, Prime.isPrime(2));
		Assert.assertEquals(true, Prime.isPrime(3));
		Assert.assertEquals(false, Prime.isPrime(4));
		Assert.assertEquals(true, Prime.isPrime(5));
		Assert.assertEquals(false, Prime.isPrime(6));
		Assert.assertEquals(true, Prime.isPrime(7));
		Assert.assertEquals(false, Prime.isPrime(8));
		Assert.assertEquals(false, Prime.isPrime(9));
		Assert.assertEquals(false, Prime.isPrime(10));
		Assert.assertEquals(true, Prime.isPrime(11));
		Assert.assertEquals(false, Prime.isPrime(12));
		Assert.assertEquals(true, Prime.isPrime(13));
		Assert.assertEquals(false, Prime.isPrime(14));
		Assert.assertEquals(false, Prime.isPrime(15));
		Assert.assertEquals(false, Prime.isPrime(16));
		Assert.assertEquals(true, Prime.isPrime(17));
		Assert.assertEquals(true, Prime.isPrime(30933103));
	}
	
//	@Test
	public void testValueOfPrimeDivisorPowers() {
		Map<Long, Integer> map = new HashMap<Long, Integer>();
		Long actual = Prime.getValueOfPrimeDivisorPowers(map);
		Long expected = 1L;
		assertEquals(expected, actual);
		
		map = new HashMap<Long, Integer>();
		map.put(2L, 1);
		actual = Prime.getValueOfPrimeDivisorPowers(map);
		expected = 2L;
		assertEquals(expected, actual);
		
		map = new HashMap<Long, Integer>();
		map.put(2L, 1);
		map.put(3L, 1);
		actual = Prime.getValueOfPrimeDivisorPowers(map);
		expected = 6L;
		assertEquals(expected, actual);
		
		map = new HashMap<Long, Integer>();
		map.put(2L, 3);
		map.put(3L, 2);
		actual = Prime.getValueOfPrimeDivisorPowers(map);
		expected = 72L;
		assertEquals(expected, actual);
	}
	
//	@Test
	public void testNextPrime() {
		assertEquals(Prime.nextPrime(1L),2L);
		assertEquals(Prime.nextPrime(2L),3L);
		assertEquals(Prime.nextPrime(3L),5L);
		assertEquals(Prime.nextPrime(5L),7L);
		assertEquals(Prime.nextPrime(7L),11L);
		assertEquals(Prime.nextPrime(11L),13L);
		assertEquals(Prime.nextPrime(13L),17L);
		assertEquals(Prime.nextPrime(17L),19L);
		assertEquals(Prime.nextPrime(19L),23L);
		
	}

}
