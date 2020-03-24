package Alibaba_20200323;

import java.util.Scanner;

/**
 * @description: problem1
 * @date: 2020/3/23 18:52
 * @author: Finallap
 * @version: 1.0
 */
public class problem1_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int num = in.nextInt();
            System.out.println(func1(num));
        }
    }

    final static int M = 1000000007;

    private static long fastPow2(int n) {
        if (n == 0) return 1;
        if (n == 1) return 2;
        long ans = 1;
        long base = 2;
        while (n != 0) {
            if ((n & 1) == 1)
                ans = ((ans % M) * (base % M)) % M;
            base = ((base % M) * (base % M)) % M;
            n >>= 1;
        }
        return ans % M;
    }

    //n*2^(n-1) % 1000000007
    private static int func1(int n) {
        return (int) (((n % M) * (fastPow2(n - 1) % M)) % M);
    }
}
