package ByteDance_20200418;

/**
 * @description: Problem3：判断有效括号的最长长度
 * input
 * () ( (())
 * output
 * 4
 * @date: 2020/4/18 18:27
 * @author: Finallap
 * @version: 1.0
 */
public class Problem3 {
    public static void main(String[] args) {
        System.out.println(longVal("()  (())"));
    }

    public static int longVal(String s) {
        int[] dp = new int[s.length()];
        int result = 0;

        for (int i = s.length() - 2; i >= 0; i--) {
            int index = i + 1 + dp[i + 1];
            if (s.charAt(i) == '(' && index < s.length() && s.charAt(index) == ')') {
                dp[i] = dp[i + 1] + 2;

            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
