package problem31thru40;

import static org.junit.Assert.*;

import org.junit.Test;

import utility.Prime;

public class Problem37Test {

	public Problem37Test() {
		//make sure to have Prime.nextPrimes populated...
		long p = 1;
		while (p < 4000) {
			p = Prime.nextPrime(p);
		}
	}
	
	@Test
	public void test_primeIsTruncatable() {
		long prime = 3797;
		assertTrue(Problem37.primeIsTruncatable(prime));
	}

	@Test
	public void test_getRightTruncated() {
		assertEquals(379, Problem37.getRightTruncated(3797));
	}
	
	@Test
	public void test_getLeftTruncated() {
		assertEquals(797, Problem37.getLeftTruncated(3797));
	}
	
}
