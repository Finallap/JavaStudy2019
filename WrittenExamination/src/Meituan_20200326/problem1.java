package Meituan_20200326;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @description: problem1
 * 题目描述：
 * 首先给出你一个整数，可能为正也可能为负，这个数字中仅包含数字1-9，现在定义一个1-9的置换，即指定将整数中的某个数字按顺序变换为另一个数字，请你输出变换以后的数字是多少。
 * <p>
 * 输入
 * 输入第一行包含一个整数a。(-10^1000<=a<=10^1000)
 * 输入第二行包含9个以空格隔开的整数a_i , 第i个整数表示将数字i替换为数字a_i。(1<=a_i<=9)
 * <p>
 * 输出
 * 请你输出数字变换之后的结果。
 * <p>
 * 样例输入
 * 1234567
 * 9 8 7 6 5 4 3 2 1
 * 样例输出
 * 9876543
 * @date: 2020/3/26 19:04
 * @author: Finallap
 * @version: 1.0
 */
public class problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        String aStr = sc.nextLine();
        String[] aNumStr = aStr.split(" ");
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < aNumStr.length; i++) {
            map.put(i, Integer.parseInt(aNumStr[i]));
        }

        StringBuffer sb = new StringBuffer();
        int index = 0;
        if (num.charAt(0) == '-') {
            sb.append('-');
            index = 1;
        }
        while (index < num.length()) {
            int afterTrans = map.get(num.charAt(index) - '1');
            sb.append(afterTrans);
            index++;
        }

        System.out.print(sb);
    }
}
