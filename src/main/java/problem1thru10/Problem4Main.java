package problem1thru10;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import utility.Print;

public class Problem4Main {

	/*
	 * A palindromic number reads the same both ways. 
	 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
	 * Find the largest palindrome made from the product of two 3-digit numbers.
	 */
	
	public static void main(String[] args) {
		int rL = 100;
		int rH = 999;
		int answer = largestPalendrome(rL, rH);
		Print.answer(answer);
		//906609
	}

	private static int largestPalendrome(int rLow, int rHigh) {
		//palindroms' key = the palendrome. palindromes' value = the set of multiplications which result in that palindrome.
		//Map<Integer, List<List>> palindromes = new HashMap<Integer, List<List>>();
		List<Integer> palindromes = new LinkedList<Integer>();
		
		for (int a = rLow; a <= rHigh; a++) {
			for (int b = rLow; b <= rHigh; b++) {
				int x = a*b;
				if (isPalindrome(x)) {
					palindromes.add(x);
				}
			}
		}
		
		Integer largest = Collections.max(palindromes);
		return largest;
	}

	public static boolean isPalindrome(int x) {
		return isPalindrome(x+"");
	}
	
	public static boolean isPalindrome(String s) {
		if (s.length() == 1 || s.length() == 0) {
			return true;
		} else {
			char first = s.charAt(0);
			char last = s.charAt(s.length()-1);
			if (first == last) {
				String inside = s.substring(1, s.length()-1);
				return isPalindrome(inside);
			} else {
				return false;
			}
		}
	}

}
