package problem11thru20.problem18.wrong;

public class Recursive {

	public static long triangleValueRecursive(long[][] triangle, int row, int x) {
		int length = triangle.length;
		int nextRow = row+1;
		if (length == nextRow) {
			return triangle[row][x];
		} else {
			long here = triangle[row][x];
			long left = triangleValueRecursive(triangle, row+1, x);
			long right = triangleValueRecursive(triangle, row+1, x+1);
			return here + left + right;
		}
	}
}
