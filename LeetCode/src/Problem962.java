import java.util.Stack;

/**
 * @description: LeetCode Problem962: 最大宽度坡，使用单调递减栈或排序法来解决
 * @date: 2020/4/8 10:25
 * @author: Finallap
 * @version: 1.0
 */
public class Problem962 {
    //单调递减栈法
    public int maxWidthRamp(int[] A) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= A[stack.peek()]) {
                stack.push(i);
            }
        }

        int ans = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A[i] >= A[stack.peek()]) {
                ans = Math.max(ans, i - stack.pop());
            }
        }
        return ans;
    }

    //排序法
    public int maxWidthRamp1(int[] A) {
        int[] B = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            B[i] = i;
        }
//这句Lambda表达式泛型一直有问题，无法运行
//        Arrays.sort(B, (i, j) -> ((Integer) A[(int) i]).compareTo(A[(int) j]));

        int ans = 0;
        int pre = A.length;
        for (int i : B) {
            ans = Math.max(ans, i - pre);
            pre = Math.min(pre, i);
        }
        return ans;
    }
}
