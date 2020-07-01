package problem1thru10;

import utility.Print;
import utility.Pythagorus;

public class Problem9 {

	/*
	 * pythagorean triplet is a,b,c such that a < b < c and a^2 + b^2 = c^2
	 * 	e.g. 3^+4^2=5^2
	 * 
	 * There is one such triplet for which a+b+c = 1000.
	 * find abc
	 */
	
	public static void main(String[] args) {
		int answer = specialPythagoreanTriplet();
		Print.answer(answer);
		// 31875000
	}

	private static int specialPythagoreanTriplet() {
		for (int a = 1; a < 1000; a++) {
			for (int b = 1; b < 1000; b++) {
				if (a + b < 1000) {
					for (int c = 1; c < 1000; c++) {
						if (a + b + c == 1000
							&& Pythagorus.pythagoreanTriplet(a,b,c)) {
							return a*b*c;
						}
					}
				}
			}
		}
		return -1;
	}

	
	
}
