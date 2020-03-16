/**
 * @description: LeetCode problem344:反转字符串
 * @date: 2020/3/16 11:02
 * @author: Finallap
 * @version: 1.0
 */
public class problem344 {
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            char temp = s[j];
            s[j] = s[i];
            s[i] = temp;
            i++;
            j--;
        }
    }
}
