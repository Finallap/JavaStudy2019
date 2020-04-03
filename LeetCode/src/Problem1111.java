/**
 * @description: LeetCode Problem1111: 有效括号的嵌套深度
 * @date: 2020/4/3 13:09
 * @author: Finallap
 * @version: 1.0
 */
public class Problem1111 {
    //用一个数字模拟栈来匹配括号
    //过程中，保证一半括号属于A，一半属于B，通过奇偶分配，便可以实现题目要求的最深度最小
    public int[] maxDepthAfterSplit(String seq) {
        int deepth = 0;
        int[] ans = new int[seq.length()];
        for (int i = 0; i < seq.length(); i++) {
            char ch = seq.charAt(i);
            if (ch == '(') {
                deepth++;
                ans[i] = deepth % 2;
            } else {
                ans[i] = deepth % 2;
                deepth--;
            }
        }
        return ans;
    }

    public int[] maxDepthAfterSplit1(String seq) {
        int[] ans = new int[seq.length()];
        for (int i = 0; i < seq.length(); i++) {
            char ch = seq.charAt(i);
            if (ch == '(') {
                ans[i] = i % 2;
            } else {
                ans[i] = 1 - i % 2;
            }
        }
        return ans;
    }

    //要让A和B的最大深度最小，关键就是，AB你俩的深度谁都别涨太快
    // 涨深度的时候，谁比较浅，我就给谁涨。降的时候，谁比较深，我就给谁降。
    public int[] maxDepthAfterSplit2(String seq) {
        int a = 0, b = 0;
        int[] ans = new int[seq.length()];
        for (int i = 0; i < seq.length(); i++) {
            char ch = seq.charAt(i);
            if (ch == '(') {
                if (a < b) {
                    a++;
                    ans[i] = 0;
                } else {
                    b++;
                    ans[i] = 1;
                }
            } else {
                if (a < b) {
                    b--;
                    ans[i] = 1;
                } else {
                    a--;
                    ans[i] = 0;
                }
            }
        }
        return ans;
    }
}
