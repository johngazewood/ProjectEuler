package problem21thru30;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import utility.AbundantNumbers;
import utility.Print;

public class Problem23 {
	
	static AbundantNumbers abundant = new AbundantNumbers();
	
	public static void main(String args[]) {
		int n = 28123;
//		int n = 10;
		long answer = nonAbundantSums(n);
		Print.answer(answer);
		//4179871
	}

	
	
	static long nonAbundantSums(int n) {
		return withThreading(n);
//		return noThreading(n);
		
		
	}



	private static long withThreading(int n) {
		int threads = 5;
		ExecutorService service = Executors.newFixedThreadPool(threads);
		List<Future<Long>> futures = new LinkedList<Future<Long>>();
		for (int t = 1; t <= threads; t++) {
			int x = (t-1)*n/threads;
			int y = (t*n)/threads;
			System.out.println(String.format("Submitting range %s, %s", x, y));
			Callable<Long> c = abundantCallableInRange(x, y);
			Future<Long> future = service.submit(c);
			futures.add(future);
		}
		
		System.out.println("we're here, right?");
		try {
			long sum = 0;
			for (Future<Long> future : futures) {
				sum += future.get();
				System.out.println("sum so far: " + sum);
			}
			
			return sum;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} finally {
			service.shutdown();
		}
		
		

		return 0;
	}



	private static Callable<Long> abundantCallableInRange(int i, int j) {
		return () -> {
		AbundantNumbers abundant = new AbundantNumbers();
		long sum = 0;
		for (long number = i; number < j; number++) {
			long value = abundant.numberIfNumberCanNOTBeWrittenAsTheSumOfTwoAbundantNumbers(number);
			sum += value;
		}
		return sum;
	};
	}



	static long noThreading(int n) {
		long sum = 0;
		for (long number = 1; number < n; number++) {
			long value = abundant.numberIfNumberCanNOTBeWrittenAsTheSumOfTwoAbundantNumbers(number);
			if (value != 0) {
				System.out.println("including " + value);
			}
			sum += value;
		}
		return sum;
	}

	
	
}
