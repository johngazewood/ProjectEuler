package problem31thru40;

import utility.Palindrome;
import utility.Print;

public class Problem36 {

	/*
	 * The decimal number, 585 = 1001001001 (binary), is palindromic in both bases.
	 * Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.
	 * (Please note that the palindromic number, in either base, may not include leading zeros.)
	 */
	
	public static void main(String[] args) {
		int n = 1000000;
		int answer = doubleBasePalindromes(n);
		Print.answer(answer);

	}

	public static int doubleBasePalindromes(int n) {
		int sum = 0;
		
		for (int i = 1; i < n; i++) {
			if (Palindrome.isPalindrome(i)) {
				String binary = Integer.toBinaryString(i);
				if (Palindrome.isPalindrome(binary)) {
					//System.out.println(String.format("Problem36>> adding %s = %s", i, binary));
					sum += i;
				}
			}
		}
		
		return sum;
	}

}
