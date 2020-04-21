/**
 * @description: KMP: KMP算法，匹配字符串，时间复杂度O(N)，空间复杂度O(M)
 * @date: 2020/4/21 16:22
 * @author: Finallap
 * @version: 1.0
 */
public class KMP {
    private final int[][] dp;
    private final String pat;

    public KMP(String pat) {
        this.pat = pat;
        int m = pat.length();
        //dp[状态][字符] = 下一个状态
        this.dp = new int[m][256];

        //base case
        dp[0][pat.charAt(0)] = 1;
        //影子状态
        int x = 0;
        for (int j = 1; j < m; j++) {
            for (int c = 0; c < 256; c++) {
                if (pat.charAt(j) == c)
                    dp[j][c] = j + 1;
                else
                    dp[j][c] = dp[x][c];
            }
            x = dp[x][pat.charAt(j)];
        }
    }

    public int search(String text) {
        //pat字符串指针的初始位置
        int j = 0;
        for (int i = 0; i < text.length(); i++) {
            j = dp[j][text.charAt(i)];
            if (j == pat.length()) {
                return i - pat.length() + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        KMP kmp = new KMP("aad");
        System.out.println(kmp.search("aabbadaadf"));
    }
}
