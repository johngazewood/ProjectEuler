package problem11thru20;

import utility.Print;

public class Problem17 {

	/*If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
	 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
	 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. 
	 * The use of "and" when writing out numbers is in compliance with British usage.
	 */
	public static void main(String args[]) {
		int n = 5;
		n = 1000;
		long answer = numberLetterCounts(n);
		Print.answer(answer);
		//21124
	}

	public static long numberLetterCounts(int n) {
		long count = 0;
		for (int i = 1; i <= n; i++) {
			String string = numberToWord(i);
			count += string.length();
		}
		return count;
	}

	public static String numberToWord(int i) {
		String word = "";
		if ( i > 1000) {
			System.out.println("Problem17>> something's gone terribly wrong. exiting.");
			System.exit(-1);
		}
		if (i == 1000) {
			word = "onethousand";
		} else if (i > 99 && i < 1000) {
			word = threeDigitNumberToWord(i);
		} else if (i > 9 && i < 100) {
			word = twoDigitNumberToWord(i);
		} else {
			word = singleDigitNumberToWord(i);
		}
		
		return word;
	}

	public static String singleDigitNumberToWord(int i) {
		switch(i) {
			case 0: return "";
			case 1: return "one";
			case 2: return "two";
			case 3: return "three";
			case 4: return "four";
			case 5: return "five";
			case 6: return "six";
			case 7: return "seven";
			case 8: return "eight";
			case 9: return "nine";
		}
		return "";
	}

	public static String twoDigitNumberToWord(int i) {
		String string = "";
		if (i < 20) {
			string = teens(i);
		} else {
			int firstDigit = i/10;
			String firstWord = "";
			switch (firstDigit) {
			case 2: firstWord="twenty"; break;
			case 3: firstWord="thirty"; break;
			case 4: firstWord="forty"; break;
			case 5: firstWord="fifty"; break;
			case 6: firstWord="sixty"; break;
			case 7: firstWord="seventy"; break;
			case 8: firstWord="eighty"; break;
			case 9: firstWord="ninety"; break;
			}
			int secondDigit = i%10;
			String secondWord = singleDigitNumberToWord(secondDigit);
			string = firstWord + secondWord;
		}
		return string;
	}

	public static String teens(int i) {
		switch(i) {
		case 10: return "ten";
		case 11: return "eleven";
		case 12: return "twelve";
		case 13: return "thirteen";
		case 14: return "fourteen";
		case 15: return "fifteen";
		case 16: return "sixteen";
		case 17: return "seventeen";
		case 18: return "eighteen";
		case 19: return "nineteen";
		}
		return "";
	}

	public static String threeDigitNumberToWord(int i) {
		String string = "";
		int hundredsDigit = i/100;
		String firstWord = singleDigitNumberToWord(hundredsDigit) + "hundred";
		
		int secondDigit = i%100;
		String secondWord = "";
		
		if (secondDigit != 0) {
			if (secondDigit < 10) {
				secondWord = singleDigitNumberToWord(secondDigit);
			} else {
				secondWord = twoDigitNumberToWord(secondDigit);
			}
			secondWord = "and" + secondWord;
		}
		string = firstWord + secondWord;
		return string;
	}
	
	
}
