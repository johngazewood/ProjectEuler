package utility;

import java.util.HashSet;
import java.util.Set;

public class ScrapUtility {

	public static void main(String[] args) {
		Set<Set<Integer>> setOfSets = new HashSet<>();
		Set<Integer> set1 = new HashSet<Integer>();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		Set<Integer> set2 = new HashSet<Integer>();
		set2.add(2);
		set2.add(1);
		set2.add(3);
		setOfSets.add(set1);
		setOfSets.add(set2);
		System.out.println("ScrapUtility: " + setOfSets);
		
	}

}
