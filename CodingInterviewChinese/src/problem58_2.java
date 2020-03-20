/**
 * @description: 剑指 problem58_2: 左旋转字符串，可以分别旋转两侧，再旋转整体
 * @date: 2020/3/20 14:38
 * @author: Finallap
 * @version: 1.0
 */
public class problem58_2 {
    public String LeftRotateString(String str, int n) {
        if (str.length() == 0)
            return str;
        char[] chars = str.toCharArray();
        reverse(chars, 0, n - 1);
        reverse(chars, n, str.length() - 1);
        reverse(chars, 0, str.length() - 1);
        return new String(chars);
    }

    public void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}
