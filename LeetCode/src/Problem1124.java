import java.util.Stack;

/**
 * @description: LeetCode Problem1124: 表现良好的最长时间段，前缀和+单调递减栈
 * @date: 2020/4/7 16:45
 * @author: Finallap
 * @version: 1.0
 */
public class Problem1124 {
    public static int longestWPI(int[] hours) {
        //求前缀和
        int[] preSum = new int[hours.length + 1];
        for (int i = 1; i < hours.length + 1; i++) {
            if (hours[i - 1] > 8) {
                preSum[i] = preSum[i - 1] + 1;
            } else {
                preSum[i] = preSum[i - 1] - 1;
            }
        }

        //构建单调递减栈
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < preSum.length; i++) {
            if (!stack.isEmpty() && preSum[i] >= preSum[stack.peek()]) {
                continue;
            }
            stack.push(i);
        }

        int ans = 0;
        for (int i = preSum.length - 1; i >= 0; i--) {
            if (preSum[i] > preSum[stack.peek()]) {
                ans = Math.max(ans, i - stack.peek());
                stack.pop();
                i++;
                if (stack.empty()) break;
                continue;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{9, 9, 6, 0, 6, 6, 9};
        longestWPI(nums);
    }
}
