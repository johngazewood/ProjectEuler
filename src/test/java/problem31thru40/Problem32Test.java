package problem31thru40;

import static org.junit.Assert.*;

import org.junit.Test;

public class Problem32Test {

	@Test
	public void test_isPandigitalProduct() {
		int a = 39;
		int b = 186;
		int ab = a*b;//=7254
		String[] nums = {a+"", b+"", ab+""};
		boolean pandigitalProduct = Problem32.isPandigitalProduct(nums);
		assertTrue(pandigitalProduct);
	}
	
	@Test
	public void test_isPandigital() {
		int a = 39;
		int b = 186;
		int ab = a*b;//=7254
		boolean pandigital= Problem32.isPandigital(ab);
		assertTrue(pandigital);
		
		
	}

}
