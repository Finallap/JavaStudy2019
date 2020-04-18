package Jingdong_20200418;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description: Problem1: AC81%
 * 一个长方体纸箱由六个面构成。
 * 现在给出六块纸板的长和宽，请你判断能否用这六块纸板构成一个长方体纸箱。
 * 输入
 * 第一行包含一个整数T，表示测试数据组数。
 * 1 <= T <= 10
 * 对于每组测试数据包含六行，每行包含两个整数h, w，表示一块纸板的长和宽。
 * 1 <= h, w <= 10^4
 * 输出
 * 对于每组测试数据输出一行。如果能构成纸箱则输出POSSIBLE，否则输出IMPOSSIBLE。
 * @date: 2020/4/18 18:41
 * @author: Finallap
 * @version: 1.0
 */
public class Problem1 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static boolean isCarton(int[] length) {
        Arrays.sort(length);
        if (length[0] != length[1] || length[1] != length[2] || length[2] != length[3])
            return false;
        if (length[4] != length[5] || length[5] != length[6] || length[6] != length[7])
            return false;
        return length[8] == length[9] && length[9] == length[10] && length[10] == length[11];
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int[] length = new int[12];
            for (int j = 0; j < 12; j++) {
                length[j] = in.nextInt();
            }
            boolean res = isCarton(length);
            System.out.println(res ? "POSSIBLE" : "IMPOSSIBLE");
        }
    }
}
