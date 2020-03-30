package Baidu_20200329;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description: problem2
 * @date: 2020/3/29 20:17
 * @author: Finallap
 * @version: 1.0
 */
public class problem2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] inputs = new long[n];

        for (int i = 0; i < n; i++) {
            inputs[i] = in.nextLong();
        }

        int result = 0;
        Arrays.sort(inputs);

        if (inputs[n - 1] < n) {
            System.out.println(0);
            return;
        }

        while (inputs[n - 1] >= n) {
//            inputs[n - 1] -= n;
//            for (int i = 0; i < n - 1; i++)
//                inputs[i]++;
//            result++;

            long time = Math.max((inputs[n - 1] - inputs[n - 2]) / n, 1);
            inputs[n - 1] -= time * n;
            for (int i = 0; i < n - 1; i++)
                inputs[i] += time;
            result++;
            Arrays.sort(inputs);
        }
        System.out.println(result);
    }
}
