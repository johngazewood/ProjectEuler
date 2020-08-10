package utility;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Pandigital {
	
	public static boolean isPandigital(int x) {
		
		String s = x+"";
		for (int d = 1; d <= s.length(); d++) {
			if (!s.contains(d+"")) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean isPandigital(long x) {
		String s = x+"";
		for (int d = 1; d <= s.length(); d++) {
			if (!s.contains(d+"")) {
				return false;
			}
		}
		
		return true;
	}


	public static boolean isPandigitalByZero(long x) {
		String s = x+"";
		for (int d = 0; d < s.length(); d++) {
			if (!s.contains(d+"")) {
				return false;
			}
		}
		
		return true;
	}
	
	/*
	 * e.g., a=0, b=2 gets you { 102, 120, 201, 210 }
	 */
	public static List<Long> generatePandigitals(int a) {
		List<Long> pandigitals = new LinkedList<Long>();
		
		for (long x = 1; x <= a; x++) {
			String precursor = x+"";
			List<Long> pans = generatePandigitals(a, precursor);
			pandigitals.addAll(pans);
		}
		return pandigitals;
	}

	private static List<Long> generatePandigitals(int a, String precursor) {
		List<Long> pandigitals = new LinkedList<Long>();
		
		if (precursor.length() == a+1) {
			pandigitals.add(Long.parseLong(precursor));
		} else {
			List<Long> preexisting = new LinkedList<Long>();
			Arrays.asList(precursor.split("")).forEach(p -> preexisting.add(Long.parseLong(p)));
			for (long m = 0; m <= a; m++) {
				if (!preexisting.contains(m)) {
					List<Long> pans = generatePandigitals(a, precursor+m);
					pandigitals.addAll(pans);
				}
			}
		}
		
		return pandigitals;
	}

	
}
