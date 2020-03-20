import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @description: 剑指 problem59: 滑动窗口的最大值，大顶堆或单调队列
 * @date: 2020/3/20 15:26
 * @author: Finallap
 * @version: 1.0
 */
public class problem59 {
    //使用大顶堆，大顶堆弹出的是最大的数
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (num.length == 0 || size <= 0 || size > num.length)
            return ret;

        PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o2 - o1));

        for (int i = 0; i < size; i++) {
            queue.offer(num[i]);
        }

        ret.add(queue.peek());
        for (int i = 0, j = i + size; j < num.length; i++, j++) {
            queue.remove(num[i]);
            queue.add(num[j]);
            ret.add(queue.peek());
        }
        return ret;
    }

    //维护单调队列
    public static int[] maxSlidingWindow(int[] num, int size) {
        if (num.length == 0 || size <= 0 || size > num.length)
            return new int[0];

        int index = 0;
        int[] res = new int[num.length - size + 1];
        LinkedList<Integer> qMax = new LinkedList<>();

        for (int i = 0; i < num.length; i++) {
            // 在队列不为空的情况下，如果队列尾部的元素要比当前的元素小，或等于当前的元素
            // 那么为了维持从大到小的原则，我必须让尾部元素弹出
            while (!qMax.isEmpty() && num[qMax.peekLast()] <= num[i]) {
                qMax.pollLast();
            }
            // 不走 while 的话，说明我们正常在队列尾部添加元素
            qMax.addLast(i);
            // 如果滑动窗口已经略过了队列中头部的元素，则将头部元素弹出
            if (qMax.peekFirst() == (i - size)) {
                qMax.pollFirst();
            }
            // 看看窗口有没有形成，只有形成了大小为 k 的窗口，我才能收集窗口内的最大值
            if (i >= (size - 1)) {
                res[index++] = num[qMax.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(maxSlidingWindow(num, 3));
    }
}
