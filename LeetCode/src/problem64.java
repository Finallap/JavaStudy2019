/**
 * @description: LeetCode problem64: 最小路径和，使用动态规划来解
 * @date: 2020/3/20 11:03
 * @author: Finallap
 * @version: 1.0
 */
public class problem64 {
    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0] == null || grid[0].length < 1) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];

        dp[0][0] = grid[0][0];
        for (int i = 1; i < row; i++)
            dp[i][0] = dp[i - 1][0] + grid[i][0];

        for (int j = 1; j < col; j++)
            dp[0][j] = dp[0][j - 1] + grid[0][j];

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[row - 1][col - 1];
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(nums));
    }
}
