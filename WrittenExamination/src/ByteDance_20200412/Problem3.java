package ByteDance_20200412;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description: Problem3:使用优惠券后还需要花费多少问题，AC80%
 * @date: 2020/4/12 19:34
 * @author: Finallap
 * @version: 1.0
 */
public class Problem3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i] = in.nextInt();
        }
        int result = process(a, b);
        System.out.println(result);
        in.close();
    }

    public static int process(int[] a, int[] b) {
        int cost = 0;
        Arrays.sort(a);
        Arrays.sort(b);
        int indexA = 0;

        for (int price : b) {
            while (indexA < a.length && a[indexA] <= price) {
                indexA++;
            }

            if (indexA - 1 < 0)
                indexA = 0;
            else
                indexA--;

            if (a[indexA] <= price)
                cost += (price - a[indexA]);
            else
                cost += price;
        }

        return cost;
    }
}
