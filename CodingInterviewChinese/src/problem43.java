/**
 * @description: problem43:数字 1 的个数,实在还没搞懂
 * @date: 2020/3/13 11:05
 * @author: Finallap
 * @version: 1.0
 */
public class problem43 {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for (int m = 1; m <= n; m *= 10) {
            int divider = m * 10;
            count += ((n / divider) * m + Math.min(Math.max(n % divider - m + 1, 0), m));
        }
        return count;
    }
}
