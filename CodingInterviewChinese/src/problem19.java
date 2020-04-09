/**
 * description: 剑指 problem19: 正则表达式匹配
 * author: Finallap
 * version: 1.0
 */
public class problem19 {
    public boolean match(char[] str, char[] pattern) {
        if (str.length == 0 || pattern.length == 0) return false;

        int str_len = str.length;
        int pattern_len = pattern.length;
        boolean[][] dp = new boolean[str_len + 1][pattern_len + 1];

        dp[0][0] = true;
        for (int i = 1; i <= pattern_len; i++) {
            if (pattern[i - 1] != '*')
                dp[0][i] = dp[0][i - 2];
        }

        for (int i = 1; i <= str_len; i++) {
            for (int j = 1; j <= pattern_len; j++) {
                if (str[i - 1] == pattern[j - 1] || pattern[j - 1] == '.')
                    dp[i][j] = dp[i - 1][j - 1];
                else if (pattern[j - 1] == '*') {
                    if (pattern[j - 2] == str[i - 1] || pattern[j - 2] == '*') {
                        dp[i][j] |= dp[i][j - 1];
                        dp[i][j] |= dp[i - 1][j];
                        dp[i][j] |= dp[i][j - 2];
                    } else
                        dp[i][j] = dp[i][j - 2];
                }
            }
        }

        return dp[str_len][pattern_len];
    }
}
