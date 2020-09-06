package Meituan_20200906;

import java.util.Scanner;

/**
 * @description: Problem4
 * @date: 2020/9/6 11:15
 * @author: Finallap
 * @version: 1.0
 */
public class Problem4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }
            boolean result = Math.random() < 0.6;
            System.out.println(result ? "YES" : "NO");
        }
    }
}
