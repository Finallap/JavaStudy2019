package Netease_20200407;

import java.util.Scanner;

/**
 * @description: Problem1: AC 90%
 * @date: 2020/4/7 19:48
 * @author: Finallap
 * @version: 1.0
 */
public class Problem1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n == 0) {
            System.out.println(-1);
            return;
        }

        long[] nums = new long[n];
        long[] diff = new long[n - 1];
        long min = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextLong();
            if (i > 0) {
                diff[i - 1] = nums[i] - nums[i - 1];
                min = Math.min(min, diff[i - 1]);
            }
        }

        try {
            for (int i = 0; i < diff.length; i++) {
                if (diff[i] % min != 0) {
                    System.out.println(-1);
                    return;
                }
            }
        } catch (Exception e) {
            System.out.println(-1);
            return;
        }

        System.out.println(min);
    }
}
