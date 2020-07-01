package problem11thru20.problem18;

import utility.Print;

public class Problem18 {

	
	
	
	
	public static void main(String[] args) {
//		long answer = maximumPathSum(Triangles.smallTriangle); //23
//		long answer = maximumPathSum(Triangles.obviousTriangle); // 12
		long answer = maximumPathSum(Triangles.largeTriangle);
		Print.answer(answer);
		//883

	}

	
	
	public static long maximumPathSum(long[][] triangle) {
		return BruteForce.bruteForce(triangle);
//		return SubTriangleValues.maximumPathSum_subTriangles(triangle);
//		return maximumPathSum_shortSighted(triangle);
	}
	
	


	

}
