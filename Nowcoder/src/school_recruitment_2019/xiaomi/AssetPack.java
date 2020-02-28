package school_recruitment_2019.xiaomi;

import java.util.Scanner;

//https://www.nowcoder.com/practice/a47c1795e32c43d38701af7862a4b359
//牛客2019校招题合集，小米
//资产包打包问题，使用0-1背包问题方法解决，动态规划法
public class AssetPack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] strs = input.split(",");
        int total = Integer.parseInt(strs[0]);//资产总量
        int kind = Integer.parseInt(strs[1]);//资产种类
        String[] wStr = strs[2].split(" ");
        String[] vStr = strs[3].split(" ");
        int[] weights = new int[kind];
        int[] values = new int[kind];
        for (int i = 0; i < kind; i++) {
            weights[i] = Integer.parseInt(wStr[i]);
            values[i] = Integer.parseInt(vStr[i]);
        }

        int[][] dp = new int[kind + 1][total + 1];
        for (int i = 1; i <= kind; i++)
            for (int j = 1; j <= total; j++) {
                /**放入第i件物品，分配总共空间j
                 如果j比第i件物品的重量大，说明能放入，则放入尝试；否则不能放入，此时等于不放入这件物品时的最大值
                 如果能放入，比较不放入这件物品和放入这件物品时总和的物品价值哪个更大
                 */
                /**
                 * dp[i - 1][j] 为背包重量为j,不放入第i个物品的最大价值
                 * dp[i - 1][j - kinds[i - 1]] + prices[i - 1] 为放入第i个物品+前i-1个物品中背包容量为j-i物品的重量的最大值
                 */
                if (j >= weights[i - 1])
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + values[i - 1]);
                else
                    dp[i][j] = dp[i - 1][j];
            }

        System.out.println(dp[kind][total]);
    }
}
