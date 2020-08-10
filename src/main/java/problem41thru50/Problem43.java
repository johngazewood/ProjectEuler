package problem41thru50;

import java.util.List;

import utility.Pandigital;
import utility.Print;

public class Problem43 {
	
	/*
	 * The number, 1406357289, is a 0 to 9 pandigital number because it is made up of each of the digits 0 to 9 in some order, but it also has a rather interesting sub-string divisibility property.
	 * Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note the following:
	 * d2d3d4=406 is divisible by 2
	 * d3d4d5=063 is divisible by 3
	 * d4d5d6=635 is divisible by 5
	 * d5d6d7=357 is divisible by 7
	 * d6d7d8=572 is divisible by 11
	 * d7d8d9=728 is divisible by 13
	 * d8d9d10=289 is divisible by 17
	 * Find the sum of all 0 to 9 pandigital numbers with this property.
	 */

	public static void main(String[] args) {
		long answer = subStringDivisibility();
		Print.answer(answer);
		//16695334890
	}

	private static long subStringDivisibility() {
		long sum = 0;
		
		List<Long> pandigitals = Pandigital.generatePandigitals(9);
		System.out.println("Problem43>> we have pandigitals.");
		for (Long p : pandigitals) {
			if (pandigitalHasProperty(p)) {
				System.out.println("Problem43>> has property -- " + p);
				sum += p;
			}
		}
		
		return sum;
	}

	static boolean pandigitalHasProperty(long p) {
		String s = p+"";
		boolean two = Long.parseLong(s.substring(1, 4)) % 2 == 0;
		boolean three = Long.parseLong(s.substring(2, 5)) % 3 == 0;
		boolean four = Long.parseLong(s.substring(3, 6)) % 5 == 0;
		boolean five = Long.parseLong(s.substring(4, 7)) % 7 == 0;
		boolean six = Long.parseLong(s.substring(5, 8)) % 11 == 0;
		boolean seven = Long.parseLong(s.substring(6, 9)) % 13 == 0;
		boolean eight = Long.parseLong(s.substring(7, 10)) % 17 == 0;
		
		if (two && three && four && five && six && seven && eight) {
			return true;
		} else {
//			System.out.println(String.format("Problem43>> property 2 %s, 3 %s, 4 %s, 5 %s, 6 %s, 7 %s, 8 %s", 
//					two, three, four, five, six, seven, eight));
			return false;
		}
	}

}
