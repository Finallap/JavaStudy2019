package Meituan_20200906;

import java.util.Scanner;

/**
 * @description: Problem3
 * @date: 2020/9/6 10:39
 * @author: Finallap
 * @version: 1.0
 */
public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        int[] b = new int[n];
//        for (int i = 0; i < n; i++) {
//            int bi = sc.nextInt();
//            for (int j = 0; j < n; j++) {
//                bi ^= ((i + 1) % (j + 1));
//            }
//            b[i] = bi;
//        }

        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            int bi = 0;
            for (int j = 0; j < n; j++) {
                bi ^= ((i + 1) % (j + 1));
            }
            b[i] = bi;
        }

        for (int i = 0; i < n; i++) {
            b[i] = b[i] ^ sc.nextInt();
        }

        int result = b[0];
        for (int i = 1; i < n; i++) {
            result ^= b[i];
        }

        System.out.println(result);
    }
}
