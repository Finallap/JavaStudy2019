package Huawei_20200422;

/**
 * @description: Huawei_20200422.P
 * @date: 2020/4/22 11:08
 * @author: Finallap
 * @version: 1.0
 */
public class Fibonacci {
    public static int f(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        return f(n - 1) + f(n - 2);
    }

    public static int f1(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        int a = 1;
        int b = 2;
        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = a + b;
            a = b;
            b = result;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
