import java.util.*;

/**
 * @description: problem347:前 K 个高频元素，使用HashMap统计，PriorityQueue来找topK
 * @date: 2020/3/2 11:18
 * @author: Finallap
 * @version: 1.0
 */
public class problem347 {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        //使用HashMap词频
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        //使用优先队列来解决排序问题
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return count.get(o1) - count.get(o2);
            }
        });

        //依次尝试放入所有key，但是只保留前k大的key，数量大于k时，队列删除一个元素
        for (int key : count.keySet()) {
            queue.add(key);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        //建立答案数组
        List<Integer> resultList = new LinkedList<>();
        while (!queue.isEmpty()) {
            resultList.add(queue.poll());
        }
        Collections.reverse(resultList);
        return resultList;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int k = 2;
        List<Integer> result = topKFrequent(nums, k);
        System.out.print(result.toString());
    }
}
