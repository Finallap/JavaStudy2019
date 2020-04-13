package Jianzhi;

/**
 * @description: LeetCode Problem08_11:面试题 08.11. 硬币
 * 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。
 * (结果可能会很大，你需要将结果模上1000000007)
 * @date: 2020/4/12 17:50
 * @author: Finallap
 * @version: 1.0
 */
public class Problem08_11 {
    public static int waysToChange(int n) {
        int[] dp = new int[n + 1];
        int[] coinList = {1, 5, 10, 25};

        //使用全1的硬币组合有一种情况
        for (int i = 0; i <= n; i++)
            dp[i] = 1;

        //只循环后几种硬币，因为全1的base case上面已经加上了
        for (int j = 1; j < coinList.length; j++) {
            for (int i = 1; i <= n; i++) {
                if (i >= coinList[j])
                    dp[i] = (dp[i] + dp[i - coinList[j]]) % 1000000007;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        waysToChange(5);
    }
}
