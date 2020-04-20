import java.util.Arrays;

/**
 * @description: LeetCode Problem435:无重叠区间
 * @date: 2020/4/20 19:05
 * @author: Finallap
 * @version: 1.0
 */
public class Problem435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0)
            return 0;

        //按end位置进行升序排序
        Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1]);
        //	⾄少有⼀个区间不相交
        int count = 1;
        int end = intervals[0][1];
        //	排序后，第⼀个区间就是x
        for (int[] interval : intervals) {
            if (interval[0] >= end) {
                count++;
                end = interval[1];
            }
        }
        //求出不相交的，剩下的是相交的次数
        return intervals.length - count;
    }
}
