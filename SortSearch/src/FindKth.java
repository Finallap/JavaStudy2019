import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @description: FindKth:查找第k大的数，使用优先队列搭配降序实现
 * @date: 2020/3/2 13:23
 * @author: Finallap
 * @version: 1.0
 */
public class FindKth {
    //使用优先队列搭配降序实现
    public static int findKth(int[] nums, int k) throws Exception {
        if (k <= 0 || k > nums.length) {
            throw new Exception("K值错误");
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int num : nums) {
            queue.add(num);
            if (queue.size() > k)
                queue.poll();
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        int[] array = {1, 4, 2, 7, 9, 8};
        int k = 3;
        try {
            System.out.println(findKth(array, k));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
