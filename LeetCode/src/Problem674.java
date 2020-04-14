import java.util.Arrays;

/**
 * @description: LeetCode Problem674: 最长连续递增序列，动态规划法
 * @date: 2020/4/14 14:34
 * @author: Finallap
 * @version: 1.0
 */
public class Problem674 {
    public static int findLengthOfLCIS(int[] nums) {
        if (nums.length <= 1)
            return 0;

        int result = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
                result = Math.max(result, dp[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 7};
        findLengthOfLCIS(nums);
    }
}
