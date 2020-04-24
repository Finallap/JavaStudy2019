package my.collection;

/**
 * @description: MaxPriorityQueue
 * @date: 2020/4/24 11:05
 * @author: Finallap
 * @version: 1.0
 */
public class MaxPriorityQueue<Key extends Comparable<Key>> {
    private final Key[] pq;
    private int N = 0;

    public MaxPriorityQueue(int capacity) {
        pq = (Key[]) new Comparable[capacity + 1];
    }

    public Key max() {
        return pq[1];
    }

    public void insert(Key e) {
        N++;
        pq[N] = e;
        swim(N);
    }

    public Key deleteMax() {
        Key max = pq[1];
        swap(1, N);
        pq[N] = null;
        N--;
        sink(1);
        return max;
    }

    //将较大的元素进行上浮
    private void swim(int k) {
        while (k != 1 && less(k, k / 2)) {
            swap(k, k / 2);
            k = k / 2;
        }
    }

    //将较小的元素下沉
    private void sink(int k) {
        while (2 * k <= N) {
            // 先假设左边节点较大
            int older = 2 * k;
            //如果右边节点存在，比较一下右边的大小
            if (2 * k + 1 <= N && less(older, 2 * k + 1))
                older = 2 * k + 1;
            // 结点 k 比俩孩子都大，就不必下沉了
            if (less(older, k))
                break;
            //否则交换两个节点
            swap(older, k);
            k = older;
        }
    }

    private void swap(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }
}
