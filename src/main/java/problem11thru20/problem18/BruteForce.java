package problem11thru20.problem18;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BruteForce {
	
	static Map<String, Long> pathValue = new HashMap<String, Long>();
	
	

	public static long bruteForce(long[][] triangle) {
		int pathLength = triangle.length;
		String path = generatePath(pathLength, true);
		String endingPath = generatePath(pathLength, false);
		boolean running = true;
		while (running) {
			long value = calculateValue(triangle, path);
			pathValue.put(path, value);
			path = nextPath(path, endingPath);
			running = !path.equals("done");
		}
		return Collections.max(pathValue.values());
	}

	public static String nextPath(String spath, String endingPath) {
		if (spath.equals(endingPath)) {
			return "done";
		}
		String[] path = spath.split("");
		
		int index = indexOfLastL(path);
		path[index] = "R";
		//anything after this index that is R changes to L.
		for (int i = index+1; i < path.length; i++) {
			path[i] = "L";
		}
		String nextPath = "";
		for (String p : path) {
			nextPath = nextPath + p;
		}
		return nextPath;
	}

	public static int indexOfLastL(String[] path) {
		int index = 0;
		for (int i = 0; i < path.length; i++) {
			if ("L".equals(path[i])) {
				index = i;
			}
		}
		return index;
	}

	public static long calculateValue(long[][] triangle, String path) {
		long value = 0;
		int x = 0;
		for (int row = 0; row < triangle.length; row++) {
			value += triangle[row][x];
			if (row < triangle.length-1 && "R".equals(path.charAt(row)+"")) {
				x++;
			}
		}
		return value;
	}



	private static String generatePath(int pathLength, boolean starting) {
		String path = "";
		for (int i = 0; i < pathLength; i++) {
			if (starting) {
				path = path+"L";
			} else {
				path = path+"R";
			}
			
		}
		return path;
	}

}
