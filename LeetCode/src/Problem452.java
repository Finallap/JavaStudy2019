import java.util.Arrays;

/**
 * @description: LeetCode Problem452: 用最少数量的箭引爆气球，其实就是统计不重复的区间数量
 * @date: 2020/4/20 19:24
 * @author: Finallap
 * @version: 1.0
 */
public class Problem452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0)
            return 0;
        int count = 1;
        Arrays.sort(points, (o1, o2) -> o1[1] - o2[1]);
        int end = points[0][1];
        for (int[] point : points) {
            if (point[0] > end) {
                count++;
                end = point[1];
            }
        }
        return count;
    }
}
