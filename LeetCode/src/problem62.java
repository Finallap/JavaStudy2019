/**
 * @description: problem62:不同的路径，机器人从左上走到右下角有多少条路径，采用动态规划来解决
 * @date: 2020/3/13 19:33
 * @author: Finallap
 * @version: 1.0
 */
public class problem62 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int j = 0; j < n; j++) dp[0][j] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
