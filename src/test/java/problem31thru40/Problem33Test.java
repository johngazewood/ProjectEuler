package problem31thru40;

import static org.junit.Assert.*;

import org.junit.Test;

public class Problem33Test {

	@Test
	public void test() {
		int a = 49;
		int b = 98;
		boolean actual = Problem33.fractionIsAccidentallySimplifiable(a, b);
		assertTrue(actual);
		
	}

}
