package utility;

import java.util.Set;

public class AbundantNumbers {

	public long numberIfNumberCanNOTBeWrittenAsTheSumOfTwoAbundantNumbers(long number) {
		for (long x = 1; x < number-1; x++) {
			long y = number - x;
			if (numberIsAbundant(x) && numberIsAbundant(y)) {
//				System.out.println(String.format(Thread.currentThread().getName()+":: %s can be written as the sum of the abundant numbers %s and %s", number, x, y));
				return 0;
			}
		}
		return number;
	}

	public boolean numberIsAbundant(long number) {
		Set<Long> divisors = Prime.calculateDivisors(number);
		divisors.remove(number);
		long sum = 0;
		for (Long d : divisors) {
			sum += d;
		}
		return (sum > number);
	}
	
}
