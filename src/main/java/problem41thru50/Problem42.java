package problem41thru50;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import utility.Print;

public class Problem42 {
	
	/*
	 * The nth term of the sequence of triangle numbers is given by, tn = (1/2)n(n+1); so the first ten triangle numbers are:
	 * 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
	 * By converting each letter in a word to a number corresponding to its alphabetical position and adding these values we form a word value. 
	 * For example, the word value for SKY is 19 + 11 + 25 = 55 = t10. If the word value is a triangle number then we shall call the word a triangle word.
	 * Using words.txt (right click and 'Save Link/Target As...'), a 16K text file containing nearly two-thousand common English words, how many are triangle words?
	 */

	public static void main(String[] args) {
		long answer = codedTriangle();
		Print.answer(answer);
		//162
	}

	public static long codedTriangle() {
		long count = 0;

		List<String> words = readWords();
		for (String word : words) {
			long number = wordToNumber(word);
			if (isTriangleNumber(number)) {
				count++;
			}
		}
		
		return count;
	}

	static Map<Long, Long> tNums = new HashMap<Long, Long>();
	public static boolean isTriangleNumber(long number) {
		if (tNums.values().contains(number)) {
			return true;
		} else if (tNums.isEmpty() || Collections.max(tNums.values()) < number) {
			
			long n = tNums.isEmpty() ? 1 : Collections.max(tNums.keySet())+1;
			long v = f(n);
			tNums.put(n, v);
			if (v == number) {
				return true;
			}
			while (v < number) {
				n++;
				v = f(n);
				tNums.put(n, v);
				if (v == number) {
					return true;
				}
			}
			
			return false;
		}
		return false;
	}

	private static long f(long n) {
		return (long) ((1.0/2.0)*n*(n+1));
	}

	static long wordToNumber(String word) {
		long number = 0;
		for (byte b : word.getBytes()) {
			b = (byte) (b - 64);
			number += b;
		}
		return number;
	}

	public static List<String> readWords() {
		List<String> words = new LinkedList<String>();
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("src/main/resources/problem42_words.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String line = scanner.next();
		scanner.close();
		String lineNoQuotes = line.replace("\"", "");
		words.addAll(Arrays.asList(lineNoQuotes.split(",")));
		return words;
	}

}
