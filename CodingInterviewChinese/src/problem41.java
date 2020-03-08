import java.util.PriorityQueue;

/**
 * @description: problem41:数据流的中位数，使用一个大顶堆放前半段数据，小顶堆放后半段数据，时间复杂度O(logn)
 * @date: 2020/3/8 18:41
 * @author: Finallap
 * @version: 1.0
 */
public class problem41 {
    //大顶堆放置前半部分数据，奇数时直接取最大值
    private PriorityQueue<Integer> maxQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
    //小顶堆放置后半部分数据
    private PriorityQueue<Integer> minQueue = new PriorityQueue<>();
    private int size = 0;

    public void Insert(Integer num) {
        size++;
        if ((size & 1) == 1) {
            //奇数的情况，直接放在最大堆
            //由于不知道num是不是比小顶堆里的数都小，所以可以先插入小顶堆，再取出小顶堆的最小值
            minQueue.add(num);
            maxQueue.add(minQueue.poll());
        } else {
            //偶数的情况，按理说直接放在最小堆
            //但是也需要知道num与大顶堆里数的关系，所以采用类似的方法
            maxQueue.add(num);
            minQueue.add(maxQueue.poll());
        }
    }

    public Double GetMedian() {
        if ((size & 1) == 1) {
            return (double) maxQueue.peek();
        } else
            return (minQueue.peek() + maxQueue.peek()) / 2.0;
    }

    public static void main(String[] args) {
        problem41 p = new problem41();
        p.Insert(5);
        System.out.print(p.GetMedian() + "\t");
        p.Insert(2);
        System.out.print(p.GetMedian() + "\t");
        p.Insert(3);
        System.out.print(p.GetMedian() + "\t");
        p.Insert(4);
        System.out.print(p.GetMedian() + "\t");
        p.Insert(1);
        System.out.print(p.GetMedian() + "\t");
        p.Insert(6);
        System.out.print(p.GetMedian() + "\t");
        p.Insert(7);
        System.out.print(p.GetMedian() + "\t");
        p.Insert(0);
        System.out.print(p.GetMedian() + "\t");
        p.Insert(8);
        System.out.print(p.GetMedian() + "\t");
    }
}
