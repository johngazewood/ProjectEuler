package problem1thru10;

import utility.Print;

public class Problem2Main {

	public static void main(String[] args) {
//		int n = 10;
		int n = 4000000;
		int answer = sumEvenFibonaccis(n);
		Print.answer(answer);
		//4613732 
		//correct!!
	}

	//1, 2, 3, 5, 8, ...
	
	private static int sumEvenFibonaccis(int n) {
		int sum = 0;
		
		int f1 = 1;
		int f2 = 1;
		int next = 0;
		while (f2 < n) {
			next = nextNumber(f1, f2);
			System.out.println("fibonacci number: " + next);
			if (next % 2 == 0) {
				sum += next;
			}
			f1 = f2;
			f2 = next;
		}
		
		return sum;
	}

	private static int nextNumber(int f1, int f2) {
		return f1 + f2;
	}

}
