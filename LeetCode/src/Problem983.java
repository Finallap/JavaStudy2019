import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @description: LeetCode Problem983: 最低票价，动态规划，从后往前遍历，选择最低的一种买法
 * dp[ n ]=min( dp[ n-1 ] + cost[ 0 ] , dp[ n-7 ] + cost[ 1 ] , dp[ n-30 ] + cost[ 2 ] )
 * @date: 2020/5/6 19:49
 * @author: Finallap
 * @version: 1.0
 */
public class Problem983 {
    //dp[i]的含义是从第i天到第356天行程需要的花费
    int[] dp;
    //即三种花费的costs数组
    int[] costs;
    //记录了哪些日子有行程
    Set<Integer> daySet;

    public int mincostTickets(int[] days, int[] costs) {
        this.costs = costs;
        this.dp = new int[366];
        Arrays.fill(dp, -1);
        this.daySet = new HashSet<>();
        for (int day : days) {
            daySet.add(day);
        }
        return dp(1);

    }

    public int dp(int i) {
        if (i > 365 || i <= 0) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        if (daySet.contains(i)) {
            dp[i] = Math.min(Math.min(dp(i + 1) + costs[0], dp(i + 7) + costs[1]), dp(i + 30) + costs[2]);
        } else {
            dp[i] = dp(i + 1);
        }
        return dp[i];
    }

    public int mincostTickets1(int[] days, int[] costs) {
        int len = days.length;
        int maxDay = days[len - 1];
        int minDay = days[0];
        int[] dp = new int[maxDay + 31];
        for (int d = maxDay, i = len - 1; d >= minDay; d--) {
            // i 表示 days 的索引
            if (d == days[i]) {
                dp[d] = Math.min(Math.min(dp[d + 1] + costs[0], dp[d + 7] + costs[1]), dp[d + 30] + costs[2]);
                //递减一天
                i++;
            } else {
                // 不需要出门
                dp[d] = dp[d + 1];
            }
        }
        return dp[minDay];
    }
}
