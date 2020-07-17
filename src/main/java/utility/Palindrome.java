package utility;

public class Palindrome {

	public static boolean isPalindrome(int integer) { 
		String string = integer+"";
		return isPalindrome(string);
	}

	public static boolean isPalindrome(String string) {
		if (string.length() == 1) {
			return true;
		}
		char front = string.charAt(0);
		char end = string.charAt(string.length()-1);
		if (front == end) {
			if (string.length()-2 == 0) {
				return true;
			} else {
				String substring = string.substring(1, string.length()-1);
				return isPalindrome(substring);
			}
		}
		return false;
	}
	
}
