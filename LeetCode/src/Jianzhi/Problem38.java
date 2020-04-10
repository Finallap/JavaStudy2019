package Jianzhi;

import java.util.HashSet;

/**
 * @description: 剑指 Problem38: 字符串的全排列，利用dfs+交换解决，并且设置一个set，set中已经有了便进行剪枝
 * @date: 2020/4/10 13:37
 * @author: Finallap
 * @version: 1.0
 */
public class Problem38 {
    public static String[] permutation(String s) {
        HashSet<String> set = new HashSet<>();
        char[] chars = s.toCharArray();
        dfs(0, set, chars);
        return set.toArray(new String[0]);
    }

    public static void dfs(int x, HashSet<String> resultSet, char[] chars) {
        if (x == chars.length - 1) {
            resultSet.add(String.valueOf(chars));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < chars.length; i++) {
            if (set.contains(chars[i]))
                continue;
            set.add(chars[i]);
            swap(chars, x, i);
            dfs(x + 1, resultSet, chars);
            swap(chars, x, i);
        }
    }

    public static void swap(char[] chars, int a, int b) {
        char ch = chars[a];
        chars[a] = chars[b];
        chars[b] = ch;
    }

    public static void main(String[] args) {
        String[] result = permutation("aab");
        for (String str : result)
            System.out.println(str);
    }
}
