import java.util.ArrayList;
import java.util.Arrays;

/**
 * @description: problem38:字符串的全排列，回溯法
 * @date: 2020/3/6 12:55
 * @author: Finallap
 * @version: 1.0
 */
public class problem38 {
    private ArrayList<String> results = new ArrayList<>();

    public ArrayList<String> Permutation(String str) {
        if (str.length() == 0)
            return results;
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        backtracking(chars, new boolean[chars.length], new StringBuffer());
        return results;
    }

    private void backtracking(char[] chars, boolean[] hasUsed, StringBuffer sb) {
        if (sb.length() == chars.length) {
            results.add(sb.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (hasUsed[i])
                continue;
            if (i != 0 && chars[i] == chars[i - 1] && !hasUsed[i - 1])
                continue;
            hasUsed[i] = true;
            sb.append(chars[i]);
            backtracking(chars, hasUsed, sb);
            sb.deleteCharAt(sb.length() - 1);
            hasUsed[i] = false;
        }
    }
}
