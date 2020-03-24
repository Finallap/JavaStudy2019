import java.util.Scanner;

/**
 * @description: fastPow:快速幂模板
 * https://blog.csdn.net/qq_40693171/article/details/84196079
 * @date: 2020/3/24 18:35
 * @author: Finallap
 * @version: 1.0
 */
public class fastPow {
    //    输出2^n %100000007的值
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long ans = 1;
        long base = 2;
        long c = 100000007;
        base %= c;
        for (; n != 0; n >>= 1) {
            if (n % 2 == 1)
                ans *= (ans * base) % c;
            base = (base * base) % c;
        }
        System.out.println(ans);
    }
}
