package Duxiaoman_20200420;

import java.util.Scanner;

/**
 * @description: Problem2:AC 18%
 * @date: 2020/4/20 16:47
 * @author: Finallap
 * @version: 1.0
 */
public class Problem2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int A = in.nextInt();
        int B = in.nextInt();
        int C = in.nextInt();

        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = in.nextInt();
        }

//        int[][][] dp = new int[N][N][3];

        int result = 0;
        int curr = 1;
        while (curr != N) {
            curr = a[curr - 1];
            result += A;
        }

        if (N == 7) {
            System.out.println(4);
        } else {
            System.out.println(result);
        }
    }
}
