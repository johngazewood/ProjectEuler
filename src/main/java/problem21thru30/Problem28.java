package problem21thru30;

import java.util.ArrayList;

import utility.CollectionsHelper;
import utility.Print;

public class Problem28 {

	static String initialValue = "0";
	
	class Ant {
		int x;
		int y;
		String direction;//up,down,left,right
		int newNumber = 1;
		public Ant(int x, int y, String direction) {
			super();
			this.x = x;
			this.y = y;
			this.direction = direction;
		}
		
		@Override
		public String toString() {
			return "Ant [x=" + x + ", y=" + y + ", direction=" + direction + "]";
		}

		public void move(ArrayList<ArrayList<String>> table) {
			if (rightIsEmpty(table)) {
				turnRight();
			}
			moveForwardOne();
		}
		void moveForwardOne() {
			switch (this.direction) {
			case "up": this.y = y - 1; break;
			case "down": this.y = y + 1; break;
			case "left": this.x = x - 1; break;
			case "right": this.x = x + 1; break;
			}
		}
		void turnRight() {
			switch (direction) {
			case "up": direction = "right"; break;
			case "right": direction = "down"; break;
			case "down": direction = "left"; break;
			case "left": direction = "up"; break;
			}
		}
		boolean rightIsEmpty(ArrayList<ArrayList<String>> table) {
			int column = this.x;
			int row = this.y;
			switch (this.direction) {
			case "up": column++; break;
			case "right": row++; break;
			case "down": column--; break;
			case "left": row--; break;
			}
			String string = table.get(row).get(column);
//			Integer value = Integer.parseInt(string);
//			return value == -1;
			return initialValue.equals(string);
		}
		public ArrayList<ArrayList<String>> dropNumber(ArrayList<ArrayList<String>> table) {
			String newString = newNumber+"";
			newNumber++;
			table.get(this.y).set(this.x, newString);
			return table;
		}
		
	}
	
	/*
	 * Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:
	 * 21 22 23 24 25
	 * 20  7  8  9 10
	 * 19  6  1  2 11
	 * 18  5  4  3 12
	 * 17 16 15 14 13
	 * 
	 * It can be verified that the sum of the numbers on the diagonals is 101.
	 * What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?
	 */
	
	public static void main(String[] args) {
//		int n = 5;
		int n = 1001;
		long answer = numberSpiralDiagonals(n);
		Print.answer(answer);
		//669171001
	}

	static long numberSpiralDiagonals(int n) {
		long answer = bruteForce(n);
		return answer;
	}

	static long bruteForce(int n) {
		ArrayList<ArrayList<String>> table = populateTable(n);
		long sum = sumDiagonals(table);
		return sum;
	}

	static ArrayList<ArrayList<String>> populateTable(int n) {
		ArrayList<ArrayList<String>> table = initializeTable(n);
		int column = (n-1)/2;
		int row = column;
		Ant ant = (new Problem28()).new Ant(column, row, "up");
//		int count = 0;
		while (ant.x < n && ant.y < n) {
//			showTableAndAnt(table, ant);
//			System.out.println("-------------------------");
			table = ant.dropNumber(table);
			ant.move(table);
		}
//		showTableAndAnt(table, ant);
		System.out.println(String.format("x=%s, y=%s", ant.x, ant.y));
		return table;
	}

	private static ArrayList<ArrayList<String>> initializeTable(int n) {
		ArrayList<ArrayList<String>> table = new ArrayList<ArrayList<String>>();
		
		for (int row = 0; row < n; row++) {
			table.add(new ArrayList<String>());
			for (int column = 0; column < n; column++) {
				table.get(row).add(initialValue);
			}
		}
		
		return table;
	}

	static void showTableAndAnt(ArrayList<ArrayList<String>> table, Ant ant) {
		ArrayList<ArrayList<String>> copy = CollectionsHelper.deepCopy(table);
		String rep = "";
		switch (ant.direction) {
		case "up": rep = "^"; break;
		case "down": rep = "v"; break;
		case "left": rep = "<"; break;
		case "right": rep = ">"; break;
		}
		copy.get(ant.y).set(ant.x, rep);
		copy.forEach(r -> System.out.println("table and ant>> " + r));
		
	}

	static long sumDiagonals(ArrayList<ArrayList<String>> table) {
		long sum = 1;
		int middle = table.size()/2;
		for (int index = 0; index < table.size(); index++) {
			if (index != middle) {
				//add top-left to bottom-right
				String negDiagonal = table.get(index).get(index);
				sum += Integer.parseInt(negDiagonal);
				//add bottom-left to top-right
				String posDiagonal = table.get(table.size() - index - 1).get(index);
				sum += Integer.parseInt(posDiagonal);
			}
		}
		return sum;
	}

	
	
	
}
