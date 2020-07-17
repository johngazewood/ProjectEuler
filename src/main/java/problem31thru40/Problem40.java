package problem31thru40;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import utility.Print;

public class Problem40 {

	static List<Integer> relevantPositions = new LinkedList<Integer>();
	static {
		relevantPositions.add(1);
		relevantPositions.add(10);
		relevantPositions.add(100);
		relevantPositions.add(1000);
		relevantPositions.add(10000);
		relevantPositions.add(100000);
		relevantPositions.add(1000000);
		
	}
	
	/*
	 * An irrational decimal fraction is created by concatenating the positive integers:
	 * 0.123456789101112131415161718192021...
	 * as in 0.1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21....
	 * It can be seen that the 12th digit of the fractional part is 1.
	 * If dn represents the nth digit of the fractional part, find the value of the following expression.
	 * d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000
	 * 
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int answer = champernowneConstant();
		Print.answer(answer);
		//210
	}

	private static int champernowneConstant() {
		Map<Integer, Integer> positionToValue = new HashMap<Integer, Integer>();
		int integer = 1;
		String string = integer+"";
		int basePosition = 1;
		while (basePosition <= 1000000) {
			//if we are at a relevant location, then grab info.
			int location = weAreAtRelevantLocation(basePosition, string.length());
			if (location > 0) {
				int value = getDigitValue(string, basePosition, string.length(), location);
				positionToValue.put(location, value);
				System.out.println("including digit: " + value);
			}
			//increment
			basePosition += string.length();
			integer++;
			string = integer+"";
		}
		
		
		int answer = multiplyValues(positionToValue);
		return answer;
	}
	public static int multiplyValues(Map<Integer, Integer> indexToValue) {
		int product = 1;
		Collection<Integer> values = indexToValue.values();
		for (Integer v : values) {
			product *= v;
		}
		return product;
	}

	public static int getDigitValue(String string, int baseIndex, int length, int location) {
		int index = -1;
		for (int i = 0; i < length; i++) {
			if (baseIndex+i == location) {
				index = i;
				break;
			}
		}
		return Integer.parseInt(string.charAt(index)+"");
	}

	public static int weAreAtRelevantLocation(int basePosition, int sectionSize) {
		for (int position : relevantPositions) {
			if (basePosition <= position && position < basePosition+sectionSize) {
				return position;
			}
		}
		return -1;
	}

}
