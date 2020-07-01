package problem21thru30;

import static org.junit.Assert.*;

import org.junit.Test;

public class Problem21Test {

	@Test
	public void testAmicable_284_220() {
		long amicable = Problem21.calculateAmicableNumber(220L);
		assertEquals(284L, amicable);
		amicable = Problem21.calculateAmicableNumber(284L);
		assertEquals(220L, amicable);
	}

}
