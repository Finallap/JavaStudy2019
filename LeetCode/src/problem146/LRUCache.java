package problem146;

public class LRUCache {
    public class CacheNode {
        int key;
        int value;
        CacheNode next;

        CacheNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    CacheNode root = null;
    int capacity;
    int count;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
    }

    public int get(int key) {
        if (count == 0) return -1;

        CacheNode curr = root;
        if (curr.key == key) return curr.value;
        while (curr.next != null) {
            if (curr.next.key == key) {
                CacheNode target = curr.next;
                curr.next = curr.next.next;
                target.next = root;
                root = target;

                return target.value;
            }
            curr = curr.next;
        }
        return -1;
    }

    public void put(int key, int value) {
        CacheNode newNode = new CacheNode(key, value);
        if (root == null) {
            //链表为空时
            root = newNode;
            count++;
        } else {
            //链表不为空

            //查找有没有已经存在，已经存在的话，更新值
            if (get(key) != -1) {
                root.value = value;
                return;
            }

            //如果值不存在则插入
            if (count < capacity) {
                newNode.next = root;
                root = newNode;
                count++;
            } else {
                newNode.next = root;
                root = newNode;
                CacheNode curr = root;
                while (curr.next.next != null) curr = curr.next;
                curr.next = null;
            }
        }
    }
}
