package problem11thru20;

import java.math.BigInteger;

import utility.Print;

public class Problem16 {

	public static void main(String[] args) {
//		int n = 15;
		int n = 1000;
		BigInteger answer = powerDigitSum(n);
		Print.answer(answer);
	}

	public static BigInteger powerDigitSum(int n) {
		BigInteger two = new BigInteger("2");
		BigInteger power = two.pow(n);
		String string = power.toString();
		System.out.println("2^1000: " + power);
		
		BigInteger sum = new BigInteger("0");
		for (String s : string.split("")) {
//			System.out.println("s = " + s);
			sum = sum.add(new BigInteger(s));
		}
		return sum;
	}

}
