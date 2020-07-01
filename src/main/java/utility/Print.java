package utility;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Print {
	public static void answer(int answer) {
		answer(answer+"");
	}

	public static void answer(long answer) {
		answer(answer + "");
		
	}
	
	public static void answer(String answer) {
		System.out.println("-------------------");
		System.out.println("answer is " + answer);
	}

	public static <T> void printListOfArrayList(List<ArrayList<T>> grid) {
		for (ArrayList<T> row : grid) {
			System.out.println(row);
		}
	}

	public static void answer(double answer) {
		answer(answer + "");
	}

	public static void answer(BigInteger answer) {
		answer(answer.toString());
	}
	
}
