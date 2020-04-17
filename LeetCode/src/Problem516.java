/**
 * @description: LeetCode Problem516: 最长回文子序列
 * @date: 2020/4/17 18:41
 * @author: Finallap
 * @version: 1.0
 */
public class Problem516 {
    public int longestPalindromeSubseq(String s) {
        if (s.length() <= 0)
            return 0;

        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++)
            dp[i][i] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }

        return dp[0][n - 1];
    }
}
