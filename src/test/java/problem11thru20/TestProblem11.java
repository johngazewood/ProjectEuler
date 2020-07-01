package problem11thru20;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestProblem11 {

	
	@Test
	public void testProduct() {
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);numbers.add(1);numbers.add(1);numbers.add(1);
		long actual = Problem11.product(numbers);
		assertEquals(1L, actual);
		
		numbers = new ArrayList<Integer>();
		numbers.add(1);numbers.add(1);numbers.add(0);numbers.add(1);
		actual = Problem11.product(numbers);
		assertEquals(0L, actual);
		
		
		numbers = new ArrayList<Integer>();
		numbers.add(1);numbers.add(2);numbers.add(1);numbers.add(1);
		actual = Problem11.product(numbers);
		assertEquals(2L, actual);
		
		numbers = new ArrayList<Integer>();
		numbers.add(1);numbers.add(2);numbers.add(1);numbers.add(71);
		actual = Problem11.product(numbers);
		assertEquals(142L, actual);
		
	}
}
