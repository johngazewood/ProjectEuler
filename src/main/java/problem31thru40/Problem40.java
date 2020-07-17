package problem31thru40;

import java.util.LinkedList;
import java.util.List;

import utility.Print;

public class Problem40 {

	static List<Integer> relevantIndexes = new LinkedList<Integer>();
	static {
		relevantIndexes.add(1);
		relevantIndexes.add(10);
		relevantIndexes.add(100);
		relevantIndexes.add(1000);
		relevantIndexes.add(10000);
		relevantIndexes.add(100000);
		relevantIndexes.add(1000000);
		
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
	}

	private static int champernowneConstant() {
		int d1 = 0,d10 = 0,d100 = 0,d1000 = 0,d10000 = 0,d100000 = 0,d1000000 = 0;
		
		int integer = 1;
		String string = integer+"";
		int baseIndex = 0;
		while (baseIndex <= 1000000) {
			//if we are at a relevant location, then grab info.
			if (weAreAtRelevantLocation(baseIndex, string.length())) {
				
			}
			//increment
		}
		
		
		int answer = d1*d10*d100*d1000*d10000*d100000*d1000000;
		return answer;
	}
	public static boolean weAreAtRelevantLocation(int baseIndex, int sectionSize) {
		for (int index : relevantIndexes) {
			if (baseIndex <= index && index < baseIndex+sectionSize) {
				return true;
			}
		}
		return false;
	}

}
