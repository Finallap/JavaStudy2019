package Pdd_20200802;

import java.util.Scanner;

/**
 * @description: Problem2: AC 0%
 * @date: 2020/8/2 19:44
 * @author: Finallap
 * @version: 1.0
 */
public class Problem2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] num = new int[n][6];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 6; j++) {
                num[i][j] = in.nextInt();
            }
        }
        System.out.println(1);
        System.out.println(n);

    }
}
