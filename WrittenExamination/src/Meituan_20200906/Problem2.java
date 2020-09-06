package Meituan_20200906;

import java.util.Scanner;

/**
 * 在小美的国家，任何一篇由英文字母组成的文章中，如果大小写字母的数量不相同会被认为文章不优雅。
 * 现在，小美写了一篇文章，并且交给小团来修改。小美希望文章中的大小写字母数量相同，所以她想让小团帮她把某些小写字母改成对应的大写字母，或者把某些大写字母改成对应的小写字母，使得文章变得优雅。
 * 小美给出的文章一定是由偶数长度组成的，她想知道最少修改多少个字母，才能让文章优雅。
 * <p>
 * 输入描述
 * 输入包含一个字符串S，仅包含大写字母和小写字母
 * |S|≤100000，|S|mod 2=0
 * <p>
 * 输出描述
 * 输出包含一个整数，即最少需要修改的字符数。
 * <p>
 * 样例输入
 * AAAb
 * 样例输出
 * 1
 *
 * @description: Problem2
 * @date: 2020/9/6 10:32
 * @author: Finallap
 * @version: 1.0
 */
public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int countUppercase = 0, countLowercase = 0;
        for (char ch : input.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                countLowercase++;
            } else {
                countUppercase++;
            }
        }
        int result = Math.abs(countLowercase - countUppercase) / 2;
        System.out.println(result);
    }
}
