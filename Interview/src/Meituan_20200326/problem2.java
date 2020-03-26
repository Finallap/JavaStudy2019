package Meituan_20200326;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @description: problem2
 * 有这么一个奇怪的符号：在一张正方形的纸上，有许多不同半径的圆。他们的圆心都在正方形的重心上（正方形的重心位于正方形两条对角线的交叉点上）。
 * 最大的圆的外面部分是白色的。最外层的圆环被涂成了黑色，接下来第二大的圆环被涂层白色，接下来第三大的圆环被涂层黑色。以此类推，例如下图。
 * 现在，给你这些圆的半径，请问黑色部分的面积是多少？精确到小数点后5位输出（四舍五入）。
 * <p>
 * 输入
 * 输入包含两行。第一行一个整数n，表示圆的个数。
 * 接下来n个整数，描述每个圆的半径ri。数据保证没有两个圆的半径是一样的。(1<=n<=100 , ri<=1000)
 * <p>
 * 输出
 * 输出包含一个数，代表黑色部分的面积。
 * <p>
 * 样例输入
 * 5
 * 1 2 3 4 5
 * 样例输出
 * 47.12389
 * @date: 2020/3/26 19:32
 * @author: Finallap
 * @version: 1.0
 */
public class problem2 {
    public static final double PI = 3.14159265359;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] circleR = new int[count];
        for (int i = 0; i < count; i++) {
            circleR[i] = sc.nextInt();
        }
        Arrays.sort(circleR);

        double result = 0.0;
        int index = count % 2 != 0 ? 2 : 1;
        while (index < count) {
            double bigCircleArea = PI * Math.pow(circleR[index], 2);
            double smallCircleArea = PI * Math.pow(circleR[index - 1], 2);
            result += bigCircleArea - smallCircleArea;
            index += 2;
        }

        if (count % 2 != 0) {
            result += PI * Math.pow(circleR[0], 2);
        }

        DecimalFormat df = new DecimalFormat("0.00000");
        df.setRoundingMode(RoundingMode.HALF_UP);
        System.out.print(df.format(result));
    }
}
