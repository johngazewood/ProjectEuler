package problem11thru20.problem18.wrong;

public class SubTriangleValues {

	public static long maximumPathSum_subTriangles(long[][] triangle) {
		long sum = triangle[0][0];
		int leftPath = 0;
		int rightPath = 1;
		for (int row = 1; row < triangle.length; row++) {
			long leftChoice = triangleValue(triangle, row, leftPath);
			long rightChoice = triangleValue(triangle, row, rightPath);
			//what happens if values are the same???
			//right now i'll assume that doesn't happen??
			if (leftChoice == rightChoice) {
				System.out.println(String.format("left and right are the same!! row %s, indexs %s and %s", row, leftPath, rightPath));
			} else if (leftChoice > rightChoice) {
				sum += triangle[row][leftPath];
			} else {
				sum += triangle[row][rightPath];
				leftPath++;
				rightPath++;
			}
		}
		return sum;
	}
	
	public static long triangleValue(long[][] triangle, int row, int x) {
		long value = 0;
		int width = 1;
		for (int r = row; r < triangle.length; r++) {
			for (int w = x; w < x+width; w++) {
				value += triangle[r][w];
			}
			width++;
		}
		return value;
	}
	
}
