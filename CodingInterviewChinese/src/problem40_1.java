import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @description: problem40_1:寻找前n小的数，使用优先队列解决
 * @date: 2020/3/8 16:03
 * @author: Finallap
 * @version: 1.0
 */
public class problem40_1 {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (input.length == 0 || k > input.length || k <= 0)
            return result;

        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int num : input) {
            if (queue.size() < k)
                queue.add(num);
            else if (queue.peek() > num) {
                queue.poll();
                queue.add(num);
            }
        }

        while (!queue.isEmpty())
            result.add(0, queue.poll());

        return result;
    }

    public static void main(String[] args) {
        int[] list = {51, 23, 55, 63, 85, 45, 36, 54, 25, 63, 22, 52, 36, 45, 78, 23, 56, 45, 85, 75, 96, 35, 12};
        ArrayList<Integer> result = GetLeastNumbers_Solution(list, 6);
        System.out.println(result);
    }
}
