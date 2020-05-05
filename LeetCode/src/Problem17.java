import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @description: LeetCode Problem17:电话号码的字母组合
 * @date: 2020/5/5 22:42
 * @author: Finallap
 * @version: 1.0
 */
public class Problem17 {
    HashMap<Integer, String> map = new HashMap<Integer, String>() {
        {
            put(2, "abc");
            put(3, "def");
            put(4, "ghi");
            put(5, "jkl");
            put(6, "mno");
            put(7, "pqrs");
            put(8, "tuv");
            put(9, "wxyz");
        }
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }

        result.add("");
        for (int i = 0; i < digits.length(); i++) {
            result = letterCombinations(result, digits.charAt(i));
        }

        return result;
    }

    public List<String> letterCombinations(List<String> inputList, char ch) {
        List<String> result = new ArrayList<>();
        String possibleStr = map.get(ch - '0');
        for (int i = 0; i < possibleStr.length(); i++) {
            for (String str : inputList) {
                result.add(str + possibleStr.charAt(i));
            }
        }
        return result;
    }
}
