/**
 * @description: 剑指 problem46:把数字翻译成字符串，动态规划法，从后往前计算
 * @date: 2020/3/13 17:03
 * @author: Finallap
 * @version: 1.0
 */
public class problem46 {
    public static int numDecoding(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int len = s.length();
        int[] dp = new int[len + 1];
        dp[len] = 0;
        dp[len - 1] = 1;

        //递推公式f(n-2) = f(n-1) + g(r-2,r-1) * f(r)
        for (int i = len - 2; i >= 0; i--) {
            dp[i] += dp[i + 1];
            if (Integer.parseInt(s.charAt(i) + "" + s.charAt(i + 1)) < 26) {
                dp[i] += dp[i + 2];
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.print(numDecoding("12258"));
    }
}
