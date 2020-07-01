package problem21thru30;

import static org.junit.Assert.*;

import org.junit.Test;

public class Problem26Test {

	@Test
	public void test_theRestMatches() {
		String pattern = "123";
		String decimal = "12312312";
//		assertTrue(Problem26.theRestMatches(0, pattern, decimal));
//		
//		pattern = "12";
//		decimal = "12312312";
//		assertFalse(Problem26.theRestMatches(0, pattern, decimal));
//		
//		pattern = "6";
//		decimal = "1666666666";
//		assertTrue(Problem26.theRestMatches(1, pattern, decimal));
		
		pattern = "8688524590163934426229508196721311475409836065573";
		//1/61
		decimal = "0163934426229508196721311475409836065573770491803278688524590163934426229508196721311475409836065573";
		int start = decimal.indexOf(pattern);
		assertFalse(Problem26.theRestMatches(start, pattern, decimal));
	}
	
//	@Test
	public void test_extractThePattern() {
		String decimal = "123123123";
		String actual = Problem26.extractPattern(decimal);
		assertEquals("123", actual);
		
		decimal ="1666666666666666667";
		actual = Problem26.extractPattern(decimal);
		assertEquals("6", actual);
		
		decimal ="11212121212";
		actual = Problem26.extractPattern(decimal);
		assertEquals("12", actual);
	}

	
}
