package problem21thru30;


import java.math.BigDecimal;
import java.math.RoundingMode;

import utility.Print;

public class Problem26 {

	public static void main(String[] args) {
		int n = 1000;
		//remember, 0<d<1000
		int d = reciprocalCycles(n);
		Print.answer(d);
		//983 !!
		
		
	}

	private static int reciprocalCycles(int n) {
		int d = 0;
		String biggestPattern = "";
		for (int i = 2; i < n; i++) {
			BigDecimal number = BigDecimal.ONE.divide(new BigDecimal(i), 10000, RoundingMode.FLOOR);
			String string = number+"";
			String decimal = extractDecimal(string);
			String pattern = extractPattern(decimal);
//			System.out.println(decimal+" -> "+pattern);
			if (pattern.length() > biggestPattern.length()) {
//				System.out.println("updating biggestPattern -------> " + decimal + " -> " + pattern);
				biggestPattern = pattern;
				d = i;
			}
		}
		
		return d;
	}

	static String extractPattern(String decimal) {
		String pattern = "";
		for (int start = 0; start < decimal.length(); start++) {
			int end = start+1;
			boolean notOutOfBounds = end <= decimal.length();
			boolean lessThanHalfTheSize = end - start < decimal.length() / 2;
			while(notOutOfBounds && lessThanHalfTheSize) {
				String substring = null;
				try {
					
					substring = decimal.substring(start, end);
				} catch (StringIndexOutOfBoundsException e) {
					System.out.println(String.format("Problem26>> StringIndexOutOfBoundsException for decimal %s, length %s, indexes %s to %s", 
							decimal, decimal.length(), start, end));
					System.exit(-1);
				}
				boolean matches = theRestMatches(start, substring, decimal);
				if (matches && substring.length() < decimal.length()/2) {
					return substring;
				}
				//increment and update
				end++;
				notOutOfBounds = end <= decimal.length();
				lessThanHalfTheSize = end - start < decimal.length() / 2;
			}
		}
		return pattern;
	}

	static boolean theRestMatches(int start, String pattern, String decimal) {
		String rest = decimal.substring(start);
		if (rest.equals(pattern)) {
			return false;
		}
		for (int pos = 0; pos < rest.length(); pos+=pattern.length()) {
			String substring = "";
			if (pos + pattern.length() < rest.length()) {
				substring = rest.substring(pos, pos+pattern.length());
			} else {
				substring = rest.substring(pos, rest.length());
				//e.g. if pattern is "123", but rest="12312312"
			}
			for (int x = 0; x < substring.length(); x++) {
				if (pattern.charAt(x) != substring.charAt(x)) {
					return false;
				}
			}
		}
		return true;
	}

	static String extractDecimal(String string) {
		String[] parts = string.split("\\.");
		return parts[1];
	}

}
