import java.util.Arrays;

/**
 * @description: 剑指 problem48:最长不含重复的子字符串
 * @date: 2020/3/14 14:38
 * @author: Finallap
 * @version: 1.0
 */
public class problem48 {
    public static int longestSubStringWithoutDuplication(String str) {
        int maxLen = 0;
        int currLen = 0;

        //创建一个26大小的数组，存放上一次字符出现的位置
        int[] preIndex = new int[26];
        Arrays.fill(preIndex, -1);

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int index = ch - 'a';
            if (preIndex[index] == -1 || i - preIndex[index] > currLen) {
                currLen++;
            } else {
                maxLen = Math.max(currLen, maxLen);
                currLen = i - preIndex[index];
            }
            preIndex[index] = i;
        }

        //一定要记得最后再判断一次
        maxLen = Math.max(currLen, maxLen);
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(longestSubStringWithoutDuplication("arabcacfr"));
    }
}
