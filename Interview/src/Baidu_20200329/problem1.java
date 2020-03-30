package Baidu_20200329;

import java.util.Scanner;

/**
 * @description: problem1
 * @date: 2020/3/29 18:55
 * @author: Finallap
 * @version: 1.0
 */
public class problem1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long result = 0;
//        for (int a = 1; a < n; a++) {
//            for (int b = a + 1; b <= n; b++) {
//        for (int a = n - 1; a >= 1; a--) {
//            for (int b = a - 1; b > 1; b--) {
//                int gcd = gcd(a, b);
//                long currRes = (a * b) / gcd - gcd;
//                result = Math.max(result, currRes);
//            }
//        }

        long a = n, b = n - 1;
        long gcd = gcd(a, b);
        long currRes = (a * b) / gcd - gcd;
        result = Math.max(result, currRes);
//        for (int a = n - 1; a >= n - 100 && a > 0; a--) {
//            int b = a + 1;
//            int gcd = gcd(a, b);
//            long currRes = (a * b) / gcd - gcd;
//            result = Math.max(result, currRes);
//        }
        System.out.println(result);
    }

    public static long gcd(long n1, long n2) {
        long gcd = 0;
        if (n1 < n2) {
            long temp = n1;
            n1 = n2;
            n2 = temp;
        }
        if (n1 % n2 == 0) {
            gcd = n2;
        }

        while (n1 % n2 > 0) {
            n1 = n1 % n2;

            if (n1 < n2) {
                long temp = n1;
                n1 = n2;
                n2 = temp;
            }

            if (n1 % n2 == 0) {
                gcd = n2;
            }
        }
        return gcd;
    }

}
