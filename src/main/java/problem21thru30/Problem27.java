package problem21thru30;

import utility.Prime;
import utility.Print;

public class Problem27 {

	public static void main(String[] args) {
		long answer = quadraticPrimes();
		Print.answer(answer);
		//-59231
	}

	private static long quadraticPrimes() {
		int maxNumOfPrimes = -1;
		long product = -1;
		for (int b = -1000; b <= 1000; b++) {
			if (Prime.isPrime(b)) {
				for (int a = -999; a < 1000; a++) {
					int max = tryOutAAndB(a, b);
					if (max > maxNumOfPrimes) {
						maxNumOfPrimes = max;
						product = a * b;
					}
				}
			}
		}
				
		return product;
	}

	static int tryOutAAndB(int a, int b) {
		int numOfPrimes = 0;
		
		int n = 0;
		long prime = generatePrime(n, a, b);
		if (prime != b) {
			System.out.println(String.format("Problem 27>> Something went wrong... n=%s, a=%s, b=%s, prime=%s", n, a, b, prime));
			System.out.println("Problem27>> the first prime is supposed to be equal to 'b' because n=0 at the start...");
			return -1;
		}
		n++;
		numOfPrimes++;
		boolean atAPrime = true;
		while (atAPrime) {
			prime = generatePrime(n, a, b);
			if (Prime.isPrime(prime)) {
				numOfPrimes++;
			} else {
				atAPrime = false;
			}
			n++;
		}
		return numOfPrimes;
	}

	static long generatePrime(long n, long a, long b) {
		long nSquared = (long) Math.pow(n, 2);
		long prime = nSquared + a*n + b;
		return prime;
	}
	
}
