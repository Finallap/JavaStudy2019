package Jianzhi;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @description: 剑指 Problem38: 字符串的全排列，利用dfs解决，先将文字排列，如果前后两个字符相同则跳过去重
 * @date: 2020/4/10 15:46
 * @author: Finallap
 * @version: 1.0
 */
public class Problem38_1 {
    static ArrayList<String> list = new ArrayList<>();

    public static String[] permutation(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        dfs(chars, new boolean[s.length()], new StringBuffer());
        return list.toArray(new String[0]);
    }

    public static void dfs(char[] chars, boolean[] flag, StringBuffer sb) {
        if (sb.length() == chars.length) {
            list.add(sb.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (flag[i] == true)
                continue;
            if (i != 0 && chars[i] == chars[i - 1] && !flag[i - 1])
                continue;

            flag[i] = true;
            sb.append(chars[i]);
            dfs(chars, flag, sb);
            sb.deleteCharAt(sb.length() - 1);
            flag[i] = false;
        }
    }
}
