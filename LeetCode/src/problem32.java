import java.util.Stack;

/**
 * @description: LeetCode problem32: 最长有效括号
 * @date: 2020/3/23 16:12
 * @author: Finallap
 * @version: 1.0
 */
public class problem32 {
    //暴力法，时间复杂度： O(n^2)，空间复杂度O(n)
    public static int longestValidParentheses(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j <= s.length(); j += 2) {
                String subString = s.substring(i, j);
                if (isValid(subString))
                    result = Math.max(result, subString.length());
            }
        }
        return result;
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else if (!stack.empty()) {
                stack.pop();
            } else
                return false;
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.print(longestValidParentheses(")()())"));
    }

    //动态规划法
    public static int longestValidParentheses1(String s) {
        int max = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}
