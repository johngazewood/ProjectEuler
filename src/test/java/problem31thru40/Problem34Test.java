package problem31thru40;

import static org.junit.Assert.*;

import org.junit.Test;

public class Problem34Test {

	@Test
	public void testIsDigitalFactor() {
		assertTrue(Problem34.isDigitalFactor(145));
		//40585
	}

	@Test
	public void testFactorial() {
		assertEquals(2*3, Problem34.factorial(3));
		assertEquals(2*3*4, Problem34.factorial(4));
		assertEquals(2*3*4*5, Problem34.factorial(5));
	}

}
