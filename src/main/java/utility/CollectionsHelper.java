package utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CollectionsHelper {

	public static <K, V> Map<K, V> removeWithCopy(Map<K, V> map, Entry<K, V> someEntry) {
		Map<K, V> newMap = new HashMap<K, V>();
		Iterator<Entry<K, V>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<K, V> next = iterator.next();
			if (!next.getKey().equals(someEntry.getKey())) {
				newMap.put(next.getKey(), next.getValue());
			}
		}
		return newMap;
	}

	public static <V> List<V> deepCopy(List<V> list) {
		List<V> newList = new ArrayList<V>();
		for (V i : list) {
			newList.add(i);
		}
		return newList;
	}
	
	public static <V> ArrayList<V> deepCopy(ArrayList<V> list) {
		ArrayList<V> newList = new ArrayList<V>();
		for (V i : list) {
			newList.add(i);
		}
		return newList;
	}
	
}
