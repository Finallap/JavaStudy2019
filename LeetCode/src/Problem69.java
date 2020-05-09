/**
 * @description: LeetCode Problem69: x 的平方根
 * @date: 2020/5/9 19:25
 * @author: Finallap
 * @version: 1.0
 */
public class Problem69 {
    public int mySqrt(int x) {
        int low = 0;
        int high = x;
        int ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if ((long) mid * mid <= x) {
                low = mid + 1;
                ans = mid;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    //使用换底公式，换成x^(1/2) = e^((1/2)*lnx)
    public int mySqrt1(int x) {
        int ans = (int) Math.exp(0.5 * Math.log(x));
        return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }
}
