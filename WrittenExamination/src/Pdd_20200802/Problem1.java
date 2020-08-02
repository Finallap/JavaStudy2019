package Pdd_20200802;

/**
 * @description: Problem1: AC 90%
 * @date: 2020/8/2 19:24
 * @author: Finallap
 * @version: 1.0
 */

import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int n = in.nextInt();
        int sum = 0;
        int count = 0;
        for (int i = 0; i < n && in.hasNext(); i++) {
            sum += in.nextInt();
            if (sum % k == 0) {
                System.out.println("paradox");
                return;
            }
            if (sum > k) {
                sum = k - sum % k;
                count++;
            }
        }

        System.out.println((k - sum) + " " + count);
    }
}