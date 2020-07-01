package problem11thru20.problem18.wrong;

public class ShortSighted {

	public static long maximumPathSum_shortSighted(long[][] triangle) {
		long sum = triangle[0][0];
		int leftPath = 0;
		int rightPath = 1;
		for (int row = 1; row < triangle.length; row++) {
			long leftChoice = triangle[row][leftPath];
			long rightChoice = triangle[row][rightPath];
			System.out.println(String.format("row %s choose between %s and %s", row, leftChoice, rightChoice));
			//what happens if values are the same???
			//right now i'll assume that doesn't happen??
			if (leftChoice == rightChoice) {
				System.out.println(String.format("left and right are the same!! row %s, indexs %s and %s", row, leftPath, rightPath));
			} else if (leftChoice > rightChoice) {
				sum += leftChoice;
			} else {
				sum += rightChoice;
				leftPath++;
				rightPath++;
			}
		}
		return sum;
	}
	
}
