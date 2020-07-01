package problem11thru20.problem18;

import static org.junit.Assert.*;

import org.junit.Test;

public class BruteForceTest {

	
	@Test
	public void test_calculateValue_tinyTriangle() {
		long value = BruteForce.calculateValue(Triangles.tinyTriangle, "L");
		assertEquals(3, value);
		value = BruteForce.calculateValue(Triangles.tinyTriangle, "R");
		assertEquals(4, value);
	}
	@Test
	public void test_calculateValue_obviousTriangle() {
		long value = BruteForce.calculateValue(Triangles.obviousTriangle, "LL");
		assertEquals(12, value);
		value = BruteForce.calculateValue(Triangles.obviousTriangle, "LR");
		assertEquals(2, value);
		value = BruteForce.calculateValue(Triangles.obviousTriangle, "RL");
		assertEquals(3, value);
		value = BruteForce.calculateValue(Triangles.obviousTriangle, "RR");
		assertEquals(4, value);
	}
	
	
	
	@Test
	public void test_nextPath() {
		String endingPath = "R";
		String currentPath = "L";
		String nextPath = BruteForce.nextPath(currentPath, endingPath);
		assertEquals("R", nextPath);
		
		currentPath = "R";
		nextPath = BruteForce.nextPath(currentPath, endingPath);
		assertEquals("done", nextPath);
		
		endingPath = "RRRR";
		currentPath = "LLLL";
		nextPath = BruteForce.nextPath(currentPath, endingPath);
		assertEquals("LLLR", nextPath);
		
		currentPath = "LLLR";
		nextPath = BruteForce.nextPath(currentPath, endingPath);
		assertEquals("LLRL", nextPath);
		
		currentPath = "LLRL";
		nextPath = BruteForce.nextPath(currentPath, endingPath);
		assertEquals("LLRR", nextPath);
		
		currentPath = "LLRR";
		nextPath = BruteForce.nextPath(currentPath, endingPath);
		assertEquals("LRLL", nextPath);
		
		currentPath = "LRLL";
		nextPath = BruteForce.nextPath(currentPath, endingPath);
		assertEquals("LRLR", nextPath);
		
		currentPath = "LRLR";
		nextPath = BruteForce.nextPath(currentPath, endingPath);
		assertEquals("LRRL", nextPath);
		
		currentPath = "LRRL";
		nextPath = BruteForce.nextPath(currentPath, endingPath);
		assertEquals("LRRR", nextPath);
		
		currentPath = "LRRR";
		nextPath = BruteForce.nextPath(currentPath, endingPath);
		assertEquals("RLLL", nextPath);
		
		currentPath = "RLLL";
		nextPath = BruteForce.nextPath(currentPath, endingPath);
		assertEquals("RLLR", nextPath);
		
		currentPath = "RLLR";
		nextPath = BruteForce.nextPath(currentPath, endingPath);
		assertEquals("RLRL", nextPath);
		
		currentPath = "RLRL";
		nextPath = BruteForce.nextPath(currentPath, endingPath);
		assertEquals("RLRR", nextPath);
		
		currentPath = "RLRR";
		nextPath = BruteForce.nextPath(currentPath, endingPath);
		assertEquals("RRLL", nextPath);
		
		currentPath = "RRLL";
		nextPath = BruteForce.nextPath(currentPath, endingPath);
		assertEquals("RRLR", nextPath);
		
		currentPath = "RRLR";
		nextPath = BruteForce.nextPath(currentPath, endingPath);
		assertEquals("RRRL", nextPath);
		
		currentPath = "RRRL";
		nextPath = BruteForce.nextPath(currentPath, endingPath);
		assertEquals("RRRR", nextPath);
		
		currentPath = "RRRR";
		nextPath = BruteForce.nextPath(currentPath, endingPath);
		assertEquals("done", nextPath);
	}
	
	@Test
	public void test_indexOfLastL() {
		String[] path = "L".split("");
		int index = BruteForce.indexOfLastL(path);
		assertEquals(0, index);
		
		path = "LL".split("");
		index = BruteForce.indexOfLastL(path);
		assertEquals(1, index);
		
		path = "LLL".split("");
		index = BruteForce.indexOfLastL(path);
		assertEquals(2, index);
		
		path = "LRL".split("");
		index = BruteForce.indexOfLastL(path);
		assertEquals(2, index);
		path = "LLLLLLLLLLL".split("");
		index = BruteForce.indexOfLastL(path);
		assertEquals(10, index);
	}

}
