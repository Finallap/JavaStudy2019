import java.util.ArrayList;

/**
 * @description: 剑指 problem38:字符全排列，使用交换的回溯法，但是没法排除重复字符
 * @date: 2020/3/6 11:46
 * @author: Finallap
 * @version: 1.0
 */
public class problem38_1 {
    private final ArrayList<String> results = new ArrayList<>();

    public ArrayList<String> Permutation(String str) {
        if (str == null || str.length() == 0)
            return results;
        char[] strs = str.toCharArray();
        backtracking(strs, 0, results);
        return results;
    }

    private void backtracking(char[] strs, int first, ArrayList<String> results) {
        if (first == strs.length) {
            results.add(strs.toString());
        }

        for (int i = first; i < strs.length; i++) {
            swap(strs, first, i);
            backtracking(strs, first + 1, results);
            swap(strs, first, i);
        }
    }

    private void swap(char[] strs, int i, int j) {
        char temp = strs[i];
        strs[i] = strs[j];
        strs[j] = strs[i];
    }

    private String toString(char[] strs) {
        StringBuffer sb = new StringBuffer();
        for (char ch : strs) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
