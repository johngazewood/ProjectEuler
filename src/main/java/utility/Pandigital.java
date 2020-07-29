package utility;

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

}
