import java.util.PriorityQueue;
import java.util.Random;

/**
 * @description: problem703 kthLargest:数据流中的第k大元素，使用优先队列解决
 * @date: 2020/3/2 10:48
 * @author: Finallap
 * @version: 1.0
 */
public class problem703 {
    final PriorityQueue<Integer> queue;
    final int k;

    public problem703(int k, int[] nums) {
        this.k = k;
        this.queue = new PriorityQueue<>(k);
        for (int num : nums) {
            add(num);//注意这里，调用的是下方的add函数，使得队列长度一直维持在k
        }
    }

    public int add(int val) {
        if (queue.size() < k) {
            queue.offer(val);
        } else if (queue.peek() < val) {
            queue.poll();
            queue.offer(val);
        }

        return queue.peek();
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(5);
        for (int i = 0; i < 10; i++)
            queue.add(new Random().nextInt(100));

        System.out.println(queue.toString());

        for (int i = 0; i < 5; i++)
            System.out.print(queue.poll());
    }
}

