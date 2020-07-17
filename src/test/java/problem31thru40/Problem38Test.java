package problem31thru40;

import static org.junit.Assert.*;

import org.junit.Test;

public class Problem38Test {

	@Test
	public void test_isPantigital() {
		assertTrue(Problem38.isPantigital("192384576"));
		
		assertFalse(Problem38.isPantigital("19238457"));
		assertFalse(Problem38.isPantigital("19234576"));
	}
	
	@Test
	public void test_generatePandigitalMultiplier() {
		assertEquals(192384576, Problem38.generatePandigitalMultiplier(192));
		assertEquals(-1, Problem38.generatePandigitalMultiplier(191));
	}

}
