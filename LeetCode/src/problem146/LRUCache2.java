package problem146;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @description: LRUCache2:链表+HashMap+Node实现
 * @date: 2020/4/11 13:42
 * @author: Finallap
 * @version: 1.0
 */
public class LRUCache2 {
    private int capacity;
    private HashMap<Integer, Integer> map;
    private LinkedList<Node> list;

    private class Node {
        int key, val;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        list = new LinkedList<>();
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        int val = map.get(key);
        put(key, val);
        return val;
    }

    public void put(int key, int val) {
        Node node = new Node(key, val);
        if (map.containsKey(key)) {
            map.remove(key);
            map.put(key, val);
            Iterator<Node> iterator = list.iterator();
            while (iterator.hasNext()) {
                if (iterator.next().key == key) {
                    iterator.remove();
                }
            }
            list.add(node);
        } else {
            if (map.size() == capacity) {
                int firstKey = list.getFirst().key;
                map.remove(firstKey);
                list.removeFirst();
            }
            map.put(key, val);
            list.add(node);
        }
    }
}
