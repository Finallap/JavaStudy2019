package problem146;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @description: LRUCache4: LinkedHashMap实现，重写removeEldestEntry函数
 * @date: 2020/4/11 14:28
 * @author: Finallap
 * @version: 1.0
 */
public class LRUCache4 {
    int capacity;
    Map<Integer, Integer> map;

    public LRUCache4(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int val) {
        map.put(key, val);
    }
}
