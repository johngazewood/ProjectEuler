package problem31thru40;

import static org.junit.Assert.*;

import org.junit.Test;

public class Problem39Test {

	@Test
	public void test_numberOfSolutions() {
		int num = Problem39.numberOfSolutions(120);
		assertEquals(3, num);
	}

}
