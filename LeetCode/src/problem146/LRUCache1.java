package problem146;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache1 {
    int capacity;
    LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

    public LRUCache1(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            int value = map.get(key);
            map.remove(key);
            map.put(key, value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key))
            map.remove(key);
        else if (map.size() == capacity) {
            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
            iterator.next();
            iterator.remove();
        }
        map.put(key, value);
    }
}
