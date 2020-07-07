package problem31thru40;

import utility.Print;

public class Problem31 {

	/*
	 * In the United Kingdom the currency is made up of pound (£) and pence (p). There are eight coins in general circulation:
	 * 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p), and £2 (200p).
	 * It is possible to make £2 in the following way:
	 * 1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
	 * 
	 * How many different ways can £2 be made using any number of coins?
	 */
	
	public static void main(String[] args) {
		 long answer = coinSums();
		 Print.answer(answer);
		 //73682
	}

	private static long coinSums() {
		long count = -1;
		count = bruteForce();
		
		return count;
	}

	static long bruteForce() {
		int count = 0;
		//1a+2b+5c+10d+20e+50f+100g+200h = 200
		for (int a = 0; a <= (200/1); a++) {
			for (int b = 0; b <= (200/2); b++) {
				for (int c = 0; c <= (200/5); c++) {
					for (int d = 0; d <= (200/10); d++) {
						for (int e = 0; e <= (200/20); e++) {
							for (int f = 0; f <= (200/50); f++) {
								for (int g = 0; g <= (200/100); g++) {
									for (int h = 0; h <= (200/200); h++) {
										if (1*a+2*b+5*c+10*d+20*e+50*f+100*g+200*h == 200) {
											count++;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return count;
	}
	
	

}
