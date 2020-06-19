package problem1thru10;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestProblem5Powers {

	Map<Long, Integer> resultantMap;
	Map<Long, Integer> primePowers;
	
	@Before
	public void setUp() {
		resultantMap = new HashMap<Long, Integer>();
		primePowers = new HashMap<Long, Integer>();
	}
	
	@Test
	public void testBothEmpty() {
		Map<Long, Integer> actual = Problem5Main.updateResultantMap(resultantMap, primePowers);
		Map<Long, Integer> expected = new HashMap<Long, Integer>();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testResultantEmpty() {
		primePowers.put(2L, 3);
		primePowers.put(3L, 5);
		
		Map<Long, Integer> actual = Problem5Main.updateResultantMap(resultantMap, primePowers);
		Map<Long, Integer> expected = new HashMap<Long, Integer>();
		expected.put(2L, 3);
		expected.put(3L, 5);
		
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test() {
		//resultantMap.put(2L, 0);
		resultantMap.put(3L, 1);
		resultantMap.put(5L, 2);
		resultantMap.put(7L, 3);
		
		primePowers.put(2L, 1);
		primePowers.put(3L, 1);
		primePowers.put(5L, 1);
		//primePowers.put(7L, 0);
		
		Map<Long, Integer> actual = Problem5Main.updateResultantMap(resultantMap, primePowers);
		Map<Long, Integer> expected = new HashMap<Long, Integer>();
		expected.put(2L, 1);
		expected.put(3L, 1);
		expected.put(5L, 2);
		expected.put(7L, 3);
		
		Assert.assertEquals(expected, actual);
	}
	
}
