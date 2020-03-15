import java.util.HashMap;

/**
 * @description: 剑指 problem50:第一次只出现一次的字符，使用一个hashmap或数组来统计
 * @date: 2020/3/15 10:16
 * @author: Finallap
 * @version: 1.0
 */
public class problem50 {
    public int FirstNotRepeatingChar(String str) {
        int result = -1;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i)))
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            else
                map.put(str.charAt(i), 1);
        }

        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == 1) {
                result = i;
                break;
            }
        }
        return result;
    }

    public int FirstNotRepeatingChar1(String str) {
        int result = -1;
        int[] counts = new int[256];
        for (int i = 0; i < str.length(); i++) {
            counts[(int) str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (counts[(int) str.charAt(i)] == 1) {
                result = i;
                break;
            }
        }
        return result;
    }

}
