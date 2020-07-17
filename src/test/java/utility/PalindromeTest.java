package utility;

import static org.junit.Assert.*;

import org.junit.Test;

public class PalindromeTest {

	@Test
	public void test_isPalindrome() {
		assertTrue(Palindrome.isPalindrome(1));
		assertTrue(Palindrome.isPalindrome(9));
		assertTrue(Palindrome.isPalindrome(101));
		assertTrue(Palindrome.isPalindrome(181));
		assertTrue(Palindrome.isPalindrome(1212002121));
		assertTrue(Palindrome.isPalindrome(121050121));

		assertFalse(Palindrome.isPalindrome(12));
		assertFalse(Palindrome.isPalindrome(123));
		assertFalse(Palindrome.isPalindrome(1231));
		assertFalse(Palindrome.isPalindrome(121050122));
		assertFalse(Palindrome.isPalindrome(121051121));
		
	}

}
