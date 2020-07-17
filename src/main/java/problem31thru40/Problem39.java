package problem31thru40;

import java.util.HashSet;
import java.util.Set;

import utility.Print;

public class Problem39 {

	/*
	 * If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, there are exactly three solutions for p = 120.
	 * {20,48,52}, {24,45,51}, {30,40,50}
	 * For which value of p ≤ 1000, is the number of solutions maximised?
	 */
	
	public static void main(String[] args) {
		int maxP = 1000;
		int answer = integerRightTriangles(maxP);
		Print.answer(answer);
	}

	private static int integerRightTriangles(int maxPerimeter) {
		int maxSolutions = 0;
		int perimeterWithMaxSolutions = 0;
		
		for (int perimeter = 3; perimeter <= maxPerimeter; perimeter++) {
			int numOfSolutions = numberOfSolutions(perimeter);
			if (numOfSolutions > maxSolutions) {
				System.out.println(String.format("new max number of solutions for perimeter %s => %s", perimeter, numOfSolutions));
				maxSolutions = numOfSolutions;
				perimeterWithMaxSolutions = perimeter;
			}
		}
		
		return perimeterWithMaxSolutions;
	}

	public static int numberOfSolutions(int perimeter) {
		Set<Set<Integer>> solutions = new HashSet<>();
		
		for (int a = 1; a < perimeter-2; a++) {
			for (int b = 1; b < perimeter-a; b++) {
				int c = perimeter - a - b;
				if (a+b+c != perimeter) {
					System.out.println("something's messed up.");
				}
				int aSquared = (int) Math.pow(a, 2);
				int bSquared = (int) Math.pow(b, 2);
				int cSquared = (int) Math.pow(c, 2);
				if (aSquared + bSquared == cSquared) {
					Set<Integer> set = new HashSet<Integer>();
					set.add(a);set.add(b);set.add(c);
					solutions.add(set);
				}
			
			}
		}
		
		int solutionCount = solutions.size();
		return solutionCount;
	}

}
