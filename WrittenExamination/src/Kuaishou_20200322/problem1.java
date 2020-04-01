package Kuaishou_20200322;

/**
 * @description: problem1
 * @date: 2020/3/22 19:03
 * @author: Finallap
 * @version: 1.0
 */
public class problem1 {
    /**
     * 获取队中从前到后每个人与前方身高高于自己的人的最短距离
     *
     * @param height int整型一维数组 队中从前到后每个人与前方身高高于自己的人的最短距离
     * @return int整型一维数组
     * <p>
     * 输入：[175, 173, 174, 163, 182, 177]
     * 输出：[0,1,2,1,0,1]
     * <p>
     * 结果：AC100%
     */
    public static int[] DistanceToHigher(int[] height) {
        // write code here
        if (height == null || height.length == 0)
            return new int[0];

        int[] results = new int[height.length];
        if (height.length > 1)
            results[0] = 0;
        for (int i = 1; i < height.length; i++) {
            int index = i - 1;
            while (index > -1 && height[index] <= height[i]) {
                index--;
            }
            results[i] = index != -1 ? i - index : 0;
        }
        return results;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{175, 179, 174, 163, 176, 177};
        int[] results = DistanceToHigher(nums);
        for (int num : results) {
            System.out.print(num + " ");
        }
    }
}
