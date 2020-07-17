package problem31thru40;

import static org.junit.Assert.*;

import org.junit.Test;

import utility.Prime;

public class Problem35Test {

	@Test
	public void testIsACircularPrime() {
		assertTrue(Problem35.isACircularPrime(197));
		System.out.println("2 is prime? " + Prime.isPrime(2));
		
	}

	@Test
	public void testRotateDigits() {
		String digits = "1234";
		String actual = Problem35.rotateDigits(digits);
		assertEquals("2341", actual);
		
	}

}
