/**
 * @description: 剑指 problem49:丑数，利用空间换时间
 * @date: 2020/3/15 10:03
 * @author: Finallap
 * @version: 1.0
 */
public class problem49 {
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0)
            return 0;

        int index2 = 0, index3 = 0, index5 = 0;
        //把每个计算出来的丑数都保存下来
        int[] dp = new int[index];
        dp[0] = 1;
        for (int i = 1; i < index; i++) {
            //丑数都是2、3、5的倍数
            int next2 = dp[index2] * 2, next3 = dp[index3] * 3, next5 = dp[index5] * 5;
            dp[i] = Math.min(next2, Math.min(next3, next5));
            if (dp[i] % 2 == 0) index2++;
            if (dp[i] % 3 == 0) index3++;
            if (dp[i] % 5 == 0) index5++;
        }
        return dp[index - 1];
    }
}
