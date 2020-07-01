package problem21thru30;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import problem21thru30.Problem28.Ant;

public class Problem28Test {

	/*
	 * 21 22 23 24 25
	 * 20  7  8  9 10
	 * 19  6  1  2 11
	 * 18  5  4  3 12
	 * 17 16 15 14 13
	 */
	@Test
	public void test_populateTable() {
		int n = 5;
		ArrayList<ArrayList<String>> expected = new ArrayList<ArrayList<String>>();
		ArrayList<String> row1 = new ArrayList<String>();
		ArrayList<String> row2 = new ArrayList<String>();
		ArrayList<String> row3 = new ArrayList<String>();
		ArrayList<String> row4 = new ArrayList<String>();
		ArrayList<String> row5 = new ArrayList<String>();
		row1.add(21+"");row1.add(22+"");row1.add(23+"");row1.add(24+"");row1.add(25+"");
		row2.add(20+"");row2.add(7+"");row2.add(8+"");row2.add(9+"");row2.add(10+"");
		row3.add(19+"");row3.add(6+"");row3.add(1+"");row3.add(2+"");row3.add(11+"");
		row4.add(18+"");row4.add(5+"");row4.add(4+"");row4.add(3+"");row4.add(12+"");
		row5.add(17+"");row5.add(16+"");row5.add(15+"");row5.add(14+"");row5.add(13+"");
		expected.add(row1);
		expected.add(row2);
		expected.add(row3);
		expected.add(row4);
		expected.add(row5);
		ArrayList<ArrayList<String>> actual = Problem28.populateTable(n);
		assertEquals(expected, actual);
	}
	
//	@Test
	public void test_sumDiagonals() {
		ArrayList<ArrayList<String>> input = new ArrayList<ArrayList<String>>();
		ArrayList<String> row1 = new ArrayList<String>();
		ArrayList<String> row2 = new ArrayList<String>();
		ArrayList<String> row3 = new ArrayList<String>();
		ArrayList<String> row4 = new ArrayList<String>();
		ArrayList<String> row5 = new ArrayList<String>();
		row1.add(21+"");row1.add(22+"");row1.add(23+"");row1.add(24+"");row1.add(25+"");
		row2.add(20+"");row2.add(7+"");row2.add(8+"");row2.add(9+"");row2.add(10+"");
		row3.add(19+"");row3.add(6+"");row3.add(1+"");row3.add(2+"");row3.add(11+"");
		row4.add(18+"");row4.add(5+"");row4.add(4+"");row4.add(3+"");row4.add(12+"");
		row5.add(17+"");row5.add(16+"");row5.add(15+"");row5.add(14+"");row5.add(13+"");
		input.add(row1);
		input.add(row2);
		input.add(row3);
		input.add(row4);
		input.add(row5);
		long expected = 101;
		long actual = Problem28.sumDiagonals(input);
		assertEquals(expected, actual);
	}
	
//	@Test
	public void test_showTableAndAnt() {
		ArrayList<ArrayList<String>> table = new ArrayList<ArrayList<String>>();
		ArrayList<String> row1 = new ArrayList<String>();
		ArrayList<String> row2 = new ArrayList<String>();
		ArrayList<String> row3 = new ArrayList<String>();
		ArrayList<String> row4 = new ArrayList<String>();
		ArrayList<String> row5 = new ArrayList<String>();
		row1.add(21+"");row1.add(22+"");row1.add(23+"");row1.add(24+"");row1.add(25+"");
		row2.add(20+"");row2.add(7+"");row2.add(8+"");row2.add(9+"");row2.add(10+"");
		row3.add(19+"");row3.add(6+"");row3.add(1+"");row3.add(2+"");row3.add(11+"");
		row4.add(18+"");row4.add(5+"");row4.add(4+"");row4.add(3+"");row4.add(12+"");
		row5.add(17+"");row5.add(16+"");row5.add(15+"");row5.add(14+"");row5.add(13+"");
		table.add(row1);
		table.add(row2);
		table.add(row3);
		table.add(row4);
		table.add(row5);
		Ant ant = (new Problem28()).new Ant(0, 0, "up");
		System.out.println("Problem28Test.test_showTableAndAnt()>> ---------- ");
		Problem28.showTableAndAnt(table, ant);
		System.out.println("Problem28Test.test_showTableAndAnt()>> ^^^^^^^^^^ ");
	}
}
