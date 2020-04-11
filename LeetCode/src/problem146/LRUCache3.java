package problem146;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @description: LRUCache3：LinkedHashMap实现
 * @date: 2020/4/11 14:10
 * @author: Finallap
 * @version: 1.0
 */
public class LRUCache3 {
    private int capacity;
    private LinkedHashMap<Integer, Integer> cache;

    public LRUCache3(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(capacity);
    }

    public int get(int key) {
        if (!cache.containsKey(key))
            return -1;
        int val = cache.get(key);
        put(key, val);
        return val;
    }

    public void put(int key, int val) {
        if (cache.containsKey(key)) {
            cache.remove(key);
        } else if (cache.size() == capacity) {
            Iterator<Map.Entry<Integer, Integer>> iterator = cache.entrySet().iterator();
            iterator.next();
            iterator.remove();
        }
        cache.put(key, val);
    }
}
