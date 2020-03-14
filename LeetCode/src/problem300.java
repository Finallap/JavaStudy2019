/**
 * @description: LeetCode problem300: 最长上升子序列
 * @date: 2020/3/14 15:48
 * @author: Finallap
 * @version: 1.0
 */
public class problem300 {
    //动态规划
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0)
            return 0;

        int[] dp = new int[nums.length];
        dp[0] = 1;
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            int currMaxLen = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    currMaxLen = Math.max(currMaxLen, dp[j]);
                }
            }
            dp[i] = currMaxLen + 1;
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    //动态规划 + 二分查找，并未能理解
    public int lengthOfLIS1(int[] nums) {
        int maxLen = 0;
        int[] dp = new int[nums.length];
        for (int num : nums) {
            int low = 0, high = maxLen;
            while (low < high) {
                int mid = (low + high) / 2;
                if (dp[mid] < num)
                    low = mid + 1;
                else
                    high = mid;
            }
            dp[low] = num;
            if (low == maxLen)
                maxLen++;
        }
        return maxLen;
    }
}
