/**
 * @description: LeetCode Problem50: 快速幂（很重要）
 * @date: 2020/5/11 17:18
 * @author: Finallap
 * @version: 1.0
 */
public class Problem50 {
    public double myPow(double x, int n) {
        double result = 1.0;
        if (n == 0) {
            return result;
        }
//        时间复杂度O(log n)
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) {
                result *= x;
            }
            x *= x;
        }

//        时间复杂度O(n)
//        for (int i = 0; i < Math.abs(n); i++) {
//            result *= x;
//        }

        return n > 0 ? result : 1 / result;
    }
}
