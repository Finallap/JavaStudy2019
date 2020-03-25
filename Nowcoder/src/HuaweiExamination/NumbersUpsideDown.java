package HuaweiExamination;

import java.util.Scanner;

/**
 * @description: NumbersUpsideDown:数字颠倒
 * @date: 2020/3/25 16:36
 * @author: Finallap
 * @version: 1.0
 */
public class NumbersUpsideDown {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        StringBuffer sb = new StringBuffer();
        sb.append(num);

        System.out.println(sb.reverse().toString());
    }
}
