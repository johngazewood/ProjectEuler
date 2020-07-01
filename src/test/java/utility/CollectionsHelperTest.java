package utility;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class CollectionsHelperTest {

	@Test
	public void test_removeWithCopy() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("one", 1);
		map.put("two", 1);
		Map.Entry<String, Integer> entry = map.entrySet().iterator().next();
		Map<String, Integer> newMap = CollectionsHelper.removeWithCopy(map, entry);
		map.remove(entry.getKey(), entry.getValue());
		Map<String, Integer> expectedMap = new HashMap<String, Integer>();
		expectedMap.put("two", 1);
		assertEquals(expectedMap, newMap);
		assertEquals(newMap, map);
		assertFalse(newMap == map);
		assertTrue(newMap.get("two") == map.get("two"));
	}

}
