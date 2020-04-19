import java.util.Arrays;
import java.util.Collections;

/**
 * @description: LeetCode Problem151: 翻转字符串里的单词
 * @date: 2020/4/10 18:24
 * @author: Finallap
 * @version: 1.0
 */
public class Problem151 {
    public static String reverseWords(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();

        swap(chars, 0, len - 1);

        int start = 0;
        int end = 0;
        while (start < len) {
            while (end < len && chars[end] != ' ')
                ++end;
            swap(chars, start, end - 1);
            start = end + 1;
            ++end;
        }

        return String.valueOf(chars);
    }

    public static void swap(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseWords2("the sky is blue!"));
    }

    public static String reverseWords1(String s) {
        String[] strs = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = strs.length - 1; i >= 0; i--) {
            sb.append(strs[i]);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static String reverseWords2(String s) {
        String[] strs = s.trim().split(" +");
        Collections.reverse(Arrays.asList(strs));
        return String.join(" ", strs);
    }
}
