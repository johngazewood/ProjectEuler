package problem31thru40;

import java.util.Map;

import utility.Prime;
import utility.Print;

public class Problem33 {

	/*
	 * The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify it may incorrectly believe that 49/98 = 4/8, 
	 * which is correct, is obtained by cancelling the 9s.
	 * We shall consider fractions like, 30/50 = 3/5, to be trivial examples.
	 * There are exactly four non-trivial examples of this type of fraction, less than one in value, and containing two digits in the numerator and denominator.
	 * If the product of these four fractions is given in its lowest common terms, find the value of the denominator.
	 */
	public static void main(String[] args) {
		long answer = digitalCancellingFractions();
		Print.answer(answer);
		//100
	}

	private static long digitalCancellingFractions() {
		long productOfSimplifiedDenominator = 1;
		long productOfNumerators = 1;
		long productOfDenominators = 1;
		for (int a = 11; a < 100; a++) {
			//b=a+1 -> to make sure fraction is less than one (i.e. numerator is less than denominator)
			for (int b = a+1; b < 100; b++) {
				if (fractionIsAccidentallySimplifiable(a,b)) {
					System.out.println("accidentally simplifiable : " + a+" / " + b);
					productOfNumerators *= a;
					productOfDenominators *= b;
				}
			}
		}
		
		productOfSimplifiedDenominator = smallestDenomiantor(productOfNumerators, productOfDenominators);
		return productOfSimplifiedDenominator;
	}

	static long smallestDenomiantor(long a, long b) {
		long smallest = -1;
		
		Map<Long, Integer> aPrimes = Prime.getMapOfPrimeDivisorsToPowers(a);
		Map<Long, Integer> bPrimes = Prime.getMapOfPrimeDivisorsToPowers(b);
		Map<Long, Integer> intersection = Prime.intersection(aPrimes, bPrimes);
		//((double) b)/(valueOfIntersection)
		long commonDivisor = Prime.getValueOfPrimeDivisorPowers(intersection);
		if (b % commonDivisor != 0) {
			System.out.println("Something has gone terribly wrong!!");
		}
		smallest = b / commonDivisor;
		System.out.println("" + smallest);
		return smallest;
	}

	/*
	 * We know a < b.
	 */
	static boolean fractionIsAccidentallySimplifiable(int a, int b) {
		double fraction = (a + 0.0) / (b + 0.0);
		String stringA = a+"";
		String stringB = b+"";
		
		String a1 = stringA.substring(0,1);
		String a2 = stringA.substring(1,2);
		String b1 = stringB.substring(0,1);
		String b2 = stringB.substring(1,2);
		
		if (!(a2.equals("0") && b2.equals("0"))) {
			if (a1.equals(b1)) {
				double newFraction = fraction(a2, b2);
				if (fraction == newFraction) {
					return true;
				}
			}
			if (a1.equals(b2)) {
				double newFraction = fraction(a2, b1);
				if (fraction == newFraction) {
					return true;
				}
			}
			if (a2.equals(b1)) {
				double newFraction = fraction(a1, b2);
				if (fraction == newFraction) {
					return true;
				}
			} if (a2.equals(b2)) {
				double newFraction = fraction(a1, b1);
				if (fraction == newFraction) {
					return true;
				}
			}
		}
		return false;
	}

	static double fraction(String stringA, String stringB) {
		double a = Double.parseDouble(stringA);
		double b = Double.parseDouble(stringB);
		return a/b;
	}

}
