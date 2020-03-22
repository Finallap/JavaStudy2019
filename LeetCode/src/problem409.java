/**
 * @description: LeetCode problem409 :最长回文串
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * @date: 2020/3/19 22:10
 * @author: Finallap
 * @version: 1.0
 */
public class problem409 {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c : s.toCharArray())
            count[c]++;

        int ans = 0;
        for (int curr : count) {
            if (curr % 2 == 0)
                ans += curr;
            else
                ans += (curr - 1);
        }

        return ans < s.length() ? ans + 1 : ans;
    }
}
