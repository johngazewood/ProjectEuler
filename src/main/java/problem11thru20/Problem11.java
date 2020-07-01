package problem11thru20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import utility.Print;

public class Problem11 {

	/*In the 20×20 grid below, four numbers along a diagonal line have been marked in red.

08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08
49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00
81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65
52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91
22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80
24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50
32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70
67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21
24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72
21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95
78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92
16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57
86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58
19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40
04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66
88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69
04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36
20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16
20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54
01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48

The product of these numbers is 26 × 63 × 78 × 14 = 1788696.

What is the greatest product of four adjacent numbers in the same direction (up, down, left, right, or diagonally) in the 20×20 grid?
*/
	
	public static List<ArrayList<Integer>> grid = new ArrayList<ArrayList<Integer>>();
	
	private static void setGrid() {
		String r0 =  "08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08"; 
		String r1 =  "49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00"; 
		String r2 =  "81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65";
		String r3 =  "52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91";
		String r4 =  "22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80";
		String r5 =  "24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50";
		String r6 =  "32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70";
		String r7 =  "67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21";
		String r8 =  "24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72";
		String r9 =  "21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95";
		String r10 = "78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92";
		String r11 = "16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57";
		String r12 = "86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58";
		String r13 = "19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40";
		String r14 = "04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66";
		String r15 = "88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69";
		String r16 = "04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36";
		String r17 = "20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16";
		String r18 = "20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54";
		String r19 = "01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48";
		List<String> strings = new ArrayList<String>();
		strings.add(r0);strings.add(r1);strings.add(r2);strings.add(r3);strings.add(r4);strings.add(r5);strings.add(r6);
		strings.add(r7);strings.add(r8);strings.add(r9);strings.add(r10);strings.add(r11);strings.add(r12);strings.add(r13);
		strings.add(r14);strings.add(r15);strings.add(r16);strings.add(r17);strings.add(r18);strings.add(r19);
		for (String rowSingle : strings) {
			String[] rowArr = rowSingle.split(" ");
			ArrayList<Integer> rowNums = new ArrayList<Integer>();
			for (String ra : rowArr) {
				rowNums.add(Integer.parseInt(ra));
			}
			grid.add(rowNums);
		}
	}
	
	public static void main(String[] args) {
		setGrid();
//		Print.printListOfArrayList(grid);
		int l = 4;
		long answer = greatestProduct(l);
		Print.answer(answer);
		//51267216
		//70600674
	}


	

	/*
	 * //approach 1: use list of list, grabbing values by indexes.
	 * 
	 * //approach 2: use "linked map" where each value is a data element in a node which has
	 * //up, down, left, right, top right, top left, bottom right, and bottom left nodes.
	 */

	public static long greatestProduct(int l) {
		long greatestProduct = -1;
		
		long biggestHorizontal = biggestHorizontal(l);
		long biggestVertical = biggestVertical(l);
		long biggestDiagonalNegativeSlope = biggestDiagonalNegativeSlope(l);
		long biggestDiagonalPositiveSlope = biggestDiagonalPositiveSlope(l);
		Long[] longs = {biggestHorizontal, biggestVertical, biggestDiagonalNegativeSlope, biggestDiagonalPositiveSlope};
//		System.out.println("longs: " + longs[0] + ", " + longs[1]+", " +longs[2]);
		greatestProduct = Collections.max(Arrays.asList(longs));
		return greatestProduct;
	}

	private static long biggestHorizontal(int l) {
		long horizontal = 0;
		for (ArrayList<Integer> row : grid) {
			for (int i = 0; i <= row.size() - l; i++) {
				List<Integer> numbers = row.subList(i, i+l);
				long product = product(numbers);
				if (product > horizontal) {
					horizontal = product;
//					System.out.println(numbers + " => "+ product);
				}
//				System.out.println("Horizontal Numbers "+(count++)+": " + numbers);
			}
		}
		return horizontal;
	}

	private static long biggestVertical(int l) {
		long vertical = 0;
		List<Integer> numbers;
		for (int y = 0; y <= grid.size()-l; y++) {
			for (int x = 0; x < grid.get(y).size(); x++) {
				numbers = new ArrayList<Integer>();
				for (int s = 0; s < l; s++) {
					numbers.add(grid.get(y+s).get(x));
					
				}
				long product = product(numbers);
				if (product > vertical) {
					vertical = product;
//					System.out.println(numbers + " => "+ product);
				}
//				System.out.println("Vertical Numbers: " + numbers);
			}
		}
		return vertical;
	}

	private static long biggestDiagonalNegativeSlope(int l) {
		long diagonal = 0;
		List<Integer> numbers;
		for(int y = 0; y <= grid.size()-l; y++) {
			for (int x = 0; x <= grid.size()-l; x++) {
				numbers = new ArrayList<Integer>();
				for (int s = 0; s < l; s++) {
					numbers.add(grid.get(y+s).get(x+s));
				}
				long product = product(numbers);
				if (product > diagonal) {
					diagonal = product;
//					System.out.println(numbers + " => "+ product);
				}
//				System.out.println("Diagonal Numbers: " + numbers);
			}
		}
		return diagonal;
	}

	private static long biggestDiagonalPositiveSlope(int l) {
		long diagonal = 0;
		List<Integer> numbers;
		for(int y = l-1; y < grid.size(); y++) {
			for (int x = 0; x <= grid.size()-l; x++) {
				numbers = new ArrayList<Integer>();
				for (int s = 0; s < l; s++) {
					numbers.add(grid.get(y-s).get(x+s));
				}
				long product = product(numbers);
				if (product > diagonal) {
					diagonal = product;
//					System.out.println(numbers + " => "+ product);
				}
				System.out.println("Positive Slope Diagonal Numbers: " + numbers);
			}
		}
		return diagonal;
	}

	
	
	public static long product(List<Integer> integers) {
		long product = 1;
		for (Integer i : integers) {
			product *= i;
		}
		return product;
	}
	
}
