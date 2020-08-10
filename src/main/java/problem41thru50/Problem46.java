package problem41thru50;

import utility.Prime;
import utility.Print;

public class Problem46 {

	/*
	 * It was proposed by Christian Goldbach that every odd composite number can be written as the sum of a prime and twice a square.
	 * 9 = 7 + 2×1^2
	 * 15 = 7 + 2×2^2
	 * 21 = 3 + 2×3^2
	 * 25 = 7 + 2×3^2
	 * 27 = 19 + 2×2^2
	 * 33 = 31 + 2×1^2
	 * 
	 * It turns out that the conjecture was false.
	 * What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?
	 */
	
	public static void main(String[] args) {
		long answer = goldbachsOtherConjecture();
		Print.answer(answer);
	}

	static long goldbachsOtherConjecture() {
		long smallestOddComposite = -1;
		
		long x = 4;
		while (smallestOddComposite == -1) {
			if (x % 2 != 0 && !Prime.isPrime(x)) {
				boolean written = writtenAsSumOfAPrimeAndTwiceASquare(x);
				if (!written) {
					smallestOddComposite = x;
				}
			}
		}
		
		return smallestOddComposite;
	}

	static boolean writtenAsSumOfAPrimeAndTwiceASquare(long x) {
		// TODO Auto-generated method stub
		return false;
	}

}
