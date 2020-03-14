/**
 * @description: 剑指 problem47:礼物的最大价值，动态规划
 * @date: 2020/3/14 13:23
 * @author: Finallap
 * @version: 1.0
 */
public class problem47 {
    //空间复杂度:O(m*n)
    public static int getMost(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return 0;

        int rows = board.length;
        int cols = board[0].length;
        int[][] dp = new int[rows][cols];
        dp[0][0] = board[0][0];
        for (int j = 1; j < rows; j++) dp[0][j] = dp[0][j - 1] + board[0][j];
        for (int i = 1; i < cols; i++) dp[i][0] = dp[i - 1][0] + board[i][0];
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]) + board[i][j];
            }
        }
        return dp[rows - 1][cols - 1];
    }

    //空间复杂度:O(n)
    public int getMost1(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return 0;
        int n = board[0].length;
        int[] dp = new int[n];
        for (int[] values : board) {
            dp[0] += values[0];
            for (int i = 1; i < n; i++) {
                dp[i] = Math.max(dp[i], dp[i - 1]) + values[i];
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{426, 306, 641, 372, 477, 409}, {223, 172, 327, 586, 363, 553}, {292, 645, 248, 316, 711, 295}, {127, 192, 495, 208, 547, 175}, {131, 448, 178, 264, 207, 676}, {655, 407, 309, 358, 246, 714}};
        System.out.println(getMost(nums));
    }
}
