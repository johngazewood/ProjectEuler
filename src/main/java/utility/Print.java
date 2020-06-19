package utility;

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
	
}
