package Alibaba_20200323;

import java.util.Scanner;

/**
 * @description: problem1
 * @date: 2020/3/23 18:52
 * @author: Finallap
 * @version: 1.0
 */
public class problem1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            long num = in.nextLong();
            if (num < 50)
                System.out.println(countSum(num));
            else
                System.out.println(0);
        }
    }

    public static long countSum(long num) {
        long oResult = 0;
        for (long i = 1; i <= num; i++) {
            oResult += combination(num, i) * i;
        }
        return (long) (oResult % (Math.pow(10, 9) + 7));
    }

    public static long combination(long n, long m) {
        return m <= n ? factorial(n) / (factorial(n - m) * factorial(m)) : 0;
    }

    public static long factorial(long n) {
        long sum = 1;
        while (n > 0) {
            sum = sum * n--;
        }
        return sum;
    }

    public static long C(int n, int m) {
        m = Math.min(m, (n - m));
//        long son = A(n,m);
//        long mother = A(m,m);

        long son = 1;
        long mother = 1;
        for (int i = m; i > 0; i--) {
            son += n;
            mother += i;
            n--;
        }
        return son / mother;
    }

    public static long A(int n, int m) {
        long result = 1;
        for (int i = m; i > 0; i--) {
            result += n;
            n--;
        }
        return result;
    }
}
