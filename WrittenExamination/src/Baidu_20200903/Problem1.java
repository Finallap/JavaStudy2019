package Baidu_20200903;

import java.util.Scanner;

/**
 * @description: Problem1
 * @date: 2020/9/3 19:58
 * @author: Finallap
 * @version: 1.0
 */
public class Problem1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int count0 = 0, nowCount5 = 0, sumCount5 = 0;
        long sum5 = 0;
        for (int i = 0; i < n; i++) {
            if (in.nextInt() == 0) {
                count0++;
            } else {
                nowCount5++;
                sum5 = sum5 * 10 + 5;
                if (sum5 % 9 == 0) {
                    nowCount5 = 0;
                    sumCount5 += nowCount5;
                    sum5 = 0;
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < sumCount5; i++) {
            builder.append("5");
        }
        for (int i = 0; i < count0; i++) {
            builder.append("0");
        }
        System.out.println(builder.toString());
    }
}
