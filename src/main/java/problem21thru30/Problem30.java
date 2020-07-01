package problem21thru30;

import utility.Power;
import utility.Print;

public class Problem30 {

	/*
	 * Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:
	 * 1634 = 1^4 + 6^4 + 3^4 + 4^4
	 * 8208 = 8^4 + 2^4 + 0^4 + 8^4
	 * 9474 = 9^4 + 4^4 + 7^4 + 4^4
	 * 
	 * As 1 = 1^4 is not a sum it is not included.
	 * The sum of these numbers is 1634 + 8208 + 9474 = 19316.
	 * 
	 * Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
	 */
	
	public static void main(String[] args) {
//		int n = 4;
		int n = 5;
		long answer = digitFifthPowers(n);
		Print.answer(answer);
		//443839
	}

	/*
	 * 9^4 = 6561
	 * 9^5 = 59049
	 */
	
	private static long digitFifthPowers(int n) {
		long sum = 0;
		//the 'number to be written as sum of its digits to power n' is always(?) going to have a number of digits <= n (?).
		
		//i'm just goint to assume the largest number whose digits to power n equal itself is ... less than 1,000,000
		for (long number = 2; number < 1000000; number++) {
			long sodp = sumOfDigitPowers((int) number, n);
			if (sodp == number) {
				System.out.println("adding " + number);
				sum += number;
			}
		}
		
		
		return sum;
	}

	private static long sumOfDigitPowers(int number, int n) {
		String string = number+"";
		long out = 0;
		for (int index = 0; index < string.length(); index++) {
			char c = string.charAt(index);
			long x = Long.parseLong(c+"");
			long y = Power.power(x, n);
//			System.out.println(String.format("%s^%s=%s", x, n, y));
			out += y;
		}
		
		return out;
	}
	
	

}
