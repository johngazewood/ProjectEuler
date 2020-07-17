package problem31thru40;

import static org.junit.Assert.*;

import org.junit.Test;

public class Problem40Test {

	@Test
	public void test_weAreAtRelevantLocation() {
		assertEquals(1, Problem40.weAreAtRelevantLocation(1, 1));
		assertEquals(10, Problem40.weAreAtRelevantLocation(10, 2));
		assertEquals(100, Problem40.weAreAtRelevantLocation(99, 2));
		assertEquals(100, Problem40.weAreAtRelevantLocation(100, 2));
		
		assertEquals(-1, Problem40.weAreAtRelevantLocation(0, 1));
		assertEquals(-1, Problem40.weAreAtRelevantLocation(99, 1));
		assertEquals(-1, Problem40.weAreAtRelevantLocation(101, 1));
	}

	@Test
	public void test_getDigitValue() {
		String string = "693";
		assertEquals(6, Problem40.getDigitValue(string, 10, string.length(), 10));
		assertEquals(9, Problem40.getDigitValue(string, 9, string.length(), 10));
		assertEquals(3, Problem40.getDigitValue(string, 8, string.length(), 10));
		
	}
	
}
