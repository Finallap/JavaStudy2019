package DJI_20200816;

import Pdd_20200802.Problem3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @description: Problem2
 * @date: 2020/8/16 20:1x+1
 * @author: Finallap
 * @version: 1.0
 */
public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] glorys = new int[n + 1];
        int[] days = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            glorys[i] = sc.nextInt();
            days[i] = sc.nextInt();
        }

        int[][] temp = new int[n + 1][x + 1];
        int[] glorySums = new int[x + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int day = x; day >= days[i]; day--) {
                int currGlorySum = glorySums[day - days[i]] + glorys[i];
                if (glorySums[day] < currGlorySum) {
                    glorySums[day] = currGlorySum;
                    temp[i][day] = 1;
                }

            }
        }

        System.out.println(glorySums[x]);
    }
}
