/**
 * @description: LeetCode Problem72:编辑距离
 * @date: 2020/4/14 16:28
 * @author: Finallap
 * @version: 1.0
 */
public class Problem72 {
    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++)
            dp[i][0] = i;
        for (int j = 0; j <= n; j++)
            dp[0][j] = j;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1,//修改
                            Math.min(dp[i - 1][j] + 1,//删除
                                    dp[i][j - 1] + 1));//插入
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("intention", "execution"));
    }
}
