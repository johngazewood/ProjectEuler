package problem1thru10;

import org.junit.Assert;
import org.junit.Test;

public class TestProblem4Palindrome {

	@Test
	public void test() {
		Assert.assertEquals(true, Problem4Main.isPalindrome(""));
		Assert.assertEquals(true, Problem4Main.isPalindrome("1"));
		Assert.assertEquals(true, Problem4Main.isPalindrome("11"));
		Assert.assertEquals(true, Problem4Main.isPalindrome("22"));
		Assert.assertEquals(true, Problem4Main.isPalindrome("212"));
		Assert.assertEquals(true, Problem4Main.isPalindrome("1000000000000000000000000000000000000000000000001"));
		
		Assert.assertEquals(false, Problem4Main.isPalindrome("21"));
		Assert.assertEquals(false, Problem4Main.isPalindrome("12"));
		Assert.assertEquals(false, Problem4Main.isPalindrome("221"));
		Assert.assertEquals(false, Problem4Main.isPalindrome("10000030000000000000000000000000000000000000000001"));
		
	}

}
