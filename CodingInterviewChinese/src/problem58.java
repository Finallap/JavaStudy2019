/**
 * @description: 剑指 problem58:反转句子，先反转每个单词，再统一反转句子
 * @date: 2020/3/15 17:04
 * @author: Finallap
 * @version: 1.0
 */
public class problem58 {
    public static String ReverseSentence(String str) {
        if (str.length() == 0)
            return str;

        char[] chars = str.toCharArray();

        int start = 0, end = 0;
        while (end <= str.length()) {
            if (end == str.length() || chars[end] == ' ') {
                reverse(chars, start, end - 1);
                start = end + 1;
            }
            end++;
        }
        reverse(chars, 0, str.length() - 1);
        return new String(chars);
    }

    private static void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        String str = "I am a student.";
        System.out.println(ReverseSentence(str));
    }
}
