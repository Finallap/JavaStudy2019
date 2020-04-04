/**
 * @description: LeetCode Problem896:单调数列
 * @date: 2020/4/4 18:53
 * @author: Finallap
 * @version: 1.0
 */
public class Problem896 {
    //两次遍历的方法
    public boolean isMonotonic(int[] A) {
        if (A.length < 1)
            return false;

        if (A.length == 1)
            return true;

        return isDecrease(A) || isIncrease(A);
    }

    private boolean isIncrease(int[] A) {
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] <= A[i])
                continue;
            else
                return false;
        }
        return true;
    }

    private boolean isDecrease(int[] A) {
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] >= A[i])
                continue;
            else
                return false;
        }
        return true;
    }

    //一次遍历的方法，使用compare
    public boolean isMonotonic1(int[] A) {
        int store = 0;
        for (int i = 1; i < A.length; i++) {
            int c = Integer.compare(A[i - 1], A[i]);
            if (c != 0) {
                if (c != store && store != 0)
                    return false;
                store = c;
            }
        }
        return true;
    }
}
