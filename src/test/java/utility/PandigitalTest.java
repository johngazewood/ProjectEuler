package utility;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class PandigitalTest {

	@Test
	public void test_generatePandigitals() {
		List<Long> actual = Pandigital.generatePandigitals(2);
		List<Long> expected = new LinkedList<Long>();
		expected.add(102L);
		expected.add(120L);
		expected.add(201L);
		expected.add(210L);
		assertEquals(expected, actual);
	}

}
