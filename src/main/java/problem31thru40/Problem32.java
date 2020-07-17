package problem31thru40;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import utility.Prime;
import utility.Print;

public class Problem32 {

	public static void main(String[] args) {
		long answer = pandigitalProduct();
		Print.answer(answer);
	}

	private static long pandigitalProduct() {
		long sum = 0;
//		sum = approach_noThreading();
		sum = approach_threading();
		return sum;
		//45228
	}

	public static long approach_threading() {
		long sum = 0;
		// LOL don't need to go up that far..
//		int n = 9999999;
		int n = 10000;
		int threadCount = 10;
		ExecutorService service = Executors.newFixedThreadPool(threadCount);
		List<Future<Long>> futures = new LinkedList<Future<Long>>();
		for (int t = 1; t <= threadCount; t++) {
			int x = (t-1)*n/threadCount;
			int y = (t*n)/threadCount;
			System.out.println(String.format("Submitting range %s, %s", x, y));
			Callable<Long> c = pandigitalProductsSumCallableInRange(x, y);
			Future<Long> future = service.submit(c);
			futures.add(future);
		}
		System.out.println("Starting to sum thread results...");
		try {
			for (Future<Long> future : futures) {
				sum += future.get();
				System.out.println("sum so far: " + sum);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} finally {
			service.shutdown();
		}
		
		return sum;
	}

	private static Callable<Long> pandigitalProductsSumCallableInRange(int x, int y) {
		return () -> {
			long localSum = 0;
			for (int i = x; i < y; i++) {
				if (isPandigital(i)) {
					localSum += i;
				}
			}
			return localSum;
		};
	}

	public static long approach_noThreading() {
		long sum = 0;
		//code seems to not find any new ones after 7852
		
		
		
		for (int i = 0; i < 9999999; i++) {
			if (isPandigital(i)) {
				sum += i;
			}
		}
		return sum;
	}

	/*
	 * For now, we'll assume all pandigits multiplicand identities for 1 to 9
	 * are of the form a*b = ab, and never a1*a2*...*aN=P such that N > 2
	 */
	public static boolean isPandigital(int i) {
		Set<Long> divisors = Prime.calculateDivisors(i);
		Set<Long> accountedFor = new HashSet<Long>();
		for (Long d : divisors) {
			if (!accountedFor.contains(d)) {
				for (Long pair : divisors) {
					if (pair * d == i) {
						accountedFor.add(d);
						accountedFor.add(pair);
						String[] nums = {d+"", pair+"", i+""};
						boolean pandigitalProduct = isPandigitalProduct(nums);
						if (pandigitalProduct) {
							System.out.println(String.format("%s | d=%s, p=%s, d*s=%s -- is pandigital product", 
									Thread.currentThread().getName(), d, pair, i));
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	public static boolean isPandigitalProduct(String[] nums) {
		String allDigits = "";
		for (int index = 0; index < nums.length; index++) {
			allDigits = allDigits + nums[index];
		}
		if (allDigits.length() == 9) {
			for (int i = 1; i <= 9; i++) {
				if (!allDigits.contains(i+"")) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}
	
}
