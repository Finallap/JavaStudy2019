import java.util.HashMap;
import java.util.Map;

public class problem3 {
    public static int lengthOfLongestSubstring(String s) {
        int result = 0;
        int left = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)))
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            map.put(s.charAt(i), i);
            result = Math.max(result, i - left + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        String input = "abcabcbb";
        int results = lengthOfLongestSubstring(input);
        System.out.print(results);
    }
}
