import java.util.ArrayList;
import java.util.List;

/**
 * @description: LeetCode Problem22:
 * 括号生成,关键点在于生成的序列中应该有n个左括号和n个右括号
 * 可使用暴力生成或DFS生成
 * @date: 2020/5/3 21:12
 * @author: Finallap
 * @version: 1.0
 */
public class Problem22 {
    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(n, n, "");
        return result;
    }

    public void dfs(int left, int right, String currString) {
        // 左右括号都不剩余了，递归终止
        if (left == 0 && right == 0) {
            result.add(currString);
            return;
        }
        //左边括号还剩余，拼左括号
        if (left > 0) {
            dfs(left - 1, right, currString + "(");
        }
        //右边括号数量还剩余，拼右括号
        if (right > left) {
            dfs(left, right - 1, currString + ")");
        }
    }

    public static void main(String[] args) {
        Problem22 problem22 = new Problem22();
        problem22.generateParenthesis(4);
        System.out.println(problem22.result);
    }
}
