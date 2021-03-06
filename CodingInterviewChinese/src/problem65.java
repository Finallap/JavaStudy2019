/**
 * @description: 剑指 problem65: 不用加减乘除做加法
 * a ^ b 表示没有考虑进位的情况下两数的和，(a & b) << 1 就是进位。
 * 递归会终止的原因是 (a & b) << 1 最右边会多一个 0，那么继续递归，进位最右边的 0 会慢慢增多，最后进位会变为 0，递归终止。
 * @date: 2020/3/28 20:14
 * @author: Finallap
 * @version: 1.0
 */
public class problem65 {
    public int Add(int num1, int num2) {
        while (num2 != 0) {
            int sum = num1 ^ num2;
            int carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        }
        return num1;
    }
}
