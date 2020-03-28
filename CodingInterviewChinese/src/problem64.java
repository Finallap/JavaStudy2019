/**
 * @description: 剑指 problem64: 求1+2+3+...+n
 * 用递归解决，递归的终止条件是n=0
 * 利用&&的短路原理，当n>0时才计算后面，否则结束条件
 * @date: 2020/3/28 20:00
 * @author: Finallap
 * @version: 1.0
 */
public class problem64 {
    public int Sum_Solution(int n) {
        int ans = n;
        boolean b = (n > 0) && ((ans += Sum_Solution(n - 1)) > 0);
        return ans;
    }
}
