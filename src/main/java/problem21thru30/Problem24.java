package problem21thru30;

import java.util.Collections;
import java.util.LinkedList;

import utility.Print;

public class Problem24 {

	public static void main(String[] args) {
//		int n = 2;//-> 012   021   102   120   201   210
//		int i = 5;//we want the 5th element -> 201
//		int n = 3;
//		int i = 1;
		int n = 9;
		int i = 1000000;
		String answer = lexicographicPermutations(n, i);
		Print.answer(answer);
		//2783915460
	}

	private static String lexicographicPermutations(int n, int ith) {
		String ithElement = "";
		LinkedList<String> numbers = new LinkedList<>();
		for (long number = 0; number <= (long) n; number++) {
			numbers.add(number+"");
		}
		
		LinkedList<String> permutations = new LinkedList<String>();
		int numbersSize = numbers.size();
		for (int index = 0; index < numbersSize; index++) {
			String here = numbers.get(index);
			numbers.remove(here);
			permutations = recursivePermute(here,numbers,n,ith,permutations);
			if (permutations.size() >= ith) {
				break;
			}
			numbers.add(here);
			Collections.sort(numbers);
		}
		ithElement = permutations.get(ith-1);
		return ithElement;
	}

	/*
	 * With LinkedList, we can return an object such that the permutatione element and its ith-value/index are present.
	 */
	static LinkedList<String> recursivePermute(String upper, LinkedList<String> remaining, int n, int ith, LinkedList<String> permutations) {
		//i doubt removing and then adding 'here' elements will preserve ordering, so i'll keep making sure it's ordered.
		Collections.sort(remaining);
		//ending point.
		if (remaining.size() == 0) {
			permutations.add(upper);
			int size = permutations.size();
			System.out.println(size +"th: "+ upper);
			return permutations;
		}
		int remainingSize = remaining.size();
		for (int r = 0; r < remainingSize; r++) {
			String here = remaining.get(r);
			String thisUpper = upper+here;
			remaining.remove(here);
			permutations = recursivePermute(thisUpper, remaining, n, ith, permutations);
			remaining.add(here);
			//don't bother continuing once we're done.
			if (permutations.size() == ith) {
				return permutations;
			}
			Collections.sort(remaining);
		}
		return permutations;
	}

}
